package acme.features.inventor.patronages;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.PatronageStatus;
import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorPatronagesUpdate implements AbstractUpdateService<Inventor, Patronages>{

	@Autowired
	protected InventorPatronagesRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Patronages> request) {
		final int id = request.getModel().getInteger("id");
		final Patronages patronage = this.repository.findPatronagesById(id);
		
		return patronage.getInventor().getId() == request.getPrincipal().getActiveRoleId() && request.getModel().hasAttribute("status") && request.getModel().getAttribute("status").equals("PROPOSED");
	}

	@Override
	public void bind(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "legalStuff", 
			"budget", "initPeriod", "finalPeriod", "link", "patronUsername", "patronCompany","patronLink","patronStatement");
		
	}

	@Override
	public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "code", "legalStuff", 
			"budget", "initPeriod", "finalPeriod", "link", "patron");
		
	}

	@Override
	public Patronages findOne(final Request<Patronages> request) {
		assert request != null;
		return this.repository.findPatronagesById(request.getModel().getInteger("id"));
	}

	@Override
	public void validate(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("new-status")) {
			errors.state(request,request.getModel().getString("new-status").equals("ACCEPTED") || request.getModel().getString("new-status").equals("DENIED"), "new-status", "inventor.patronage.form.error.status");
		}
		if(!errors.hasErrors("initPeriod")) {


			errors.state(request,request.getModel().getString("new-status").equals("DENIED") || entity.getInitPeriod().after(Calendar.getInstance().getTime()), "initPeriod","inventor.patron.form.error.init-period");
		}
		
	}

	@Override
	public void update(final Request<Patronages> request, final Patronages entity) {
		assert request != null;
		assert entity != null;
	
		final PatronageStatus status = PatronageStatus.valueOf(request.getModel().getString("new-status"));
		entity.setStatus(status);
			
		
		this.repository.save(entity);
	}

}
