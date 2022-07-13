package acme.features.administrator.announcement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcement.Announcement;
import acme.features.spam.SpamDetector;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement>{

	@Autowired
	protected AdministratorAnnouncementRepository repository;
	
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		boolean result;

		result = request.getPrincipal().hasRole(Administrator.class);

		return result;
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creation", "title", "body", "flag", "url");
		
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creation", "title", "body", "flag", "url");
		
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;

		Announcement result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Announcement();
		result.setCreation(moment);
		result.setTitle("");
		result.setBody("");
		result.setFlag(true);
		result.setUrl("");

		return result;
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;

		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
		
		
		if (!errors.hasErrors("body")) {
			errors.state(request, SpamDetector.error(entity.getBody(),  this.repository.getSystemConfiguration()), "body", "any.form.error.spam");
		}
		

		if (!errors.hasErrors("title")) {
			errors.state(request, SpamDetector.error(entity.getTitle(),  this.repository.getSystemConfiguration()), "title", "any.form.error.spam");
		}
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreation(moment);
		this.repository.save(entity);
		
	}

}


