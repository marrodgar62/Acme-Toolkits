package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Patron;

@Service
public class PatronPatronageDeleteService implements AbstractDeleteService<Patron, Patronages>{

	@Autowired
	protected PatronPatronageRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronages> request) {
		assert request != null;
		
		boolean result;
		int patronageId;
		Patronages patronage;
		Patron patron;
		
		patronageId = request.getModel().getInteger("id");
		patronage = this.repository.findOneById(patronageId);
		patron = patronage.getPatron();
		
		result = !patronage.isPublished() && request.isPrincipal(patron);
		
		return result;
	}

	@Override
	public void bind(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "status","code","legalStuff","budget","creationTime","initPeriod","finalPeriod","link","published");
	}

	@Override
	public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "status","code","legalStuff","budget","creationTime","initPeriod","finalPeriod","link","published");
	}

	@Override
	public Patronages findOne(final Request<Patronages> request) {
		assert request != null;
		
		Patronages result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		
		return result;
	}

	@Override
	public void validate(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void delete(final Request<Patronages> request, final Patronages entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}

}
