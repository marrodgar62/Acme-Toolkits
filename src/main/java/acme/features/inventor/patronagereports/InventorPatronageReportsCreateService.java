package acme.features.inventor.patronagereports;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.PatronageStatus;
import acme.entities.patonages.Patronages;
import acme.entities.patronageReport.PatronageReport;
import acme.features.spam.SpamDetector;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportsCreateService implements AbstractCreateService<Inventor, PatronageReport>{

	@Autowired
	protected InventorPatronageReportsRepository repository;


	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		
		int patronageId;
		Inventor inventor;
		
		patronageId = request.getModel().getInteger("id");
		inventor = this.repository.findInventorByPatronageId(patronageId);
		result = request.getPrincipal().getActiveRoleId() == inventor.getId() && this.repository.findPatronageById(patronageId).getStatus() == PatronageStatus.ACCEPTED;
			
		return result;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "creationMoment", "memorandum", "link");
		
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "creationMoment", "memorandum", "link");
		model.setAttribute("patronageId", request.getModel().getInteger("id"));
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;
		
		PatronageReport result;
		Patronages patronage;
		Date creationMoment;
		
		creationMoment = new Date(System.currentTimeMillis() -1);
		
		patronage = this.repository.findPatronageById(request.getModel().getInteger("id"));
		result = new PatronageReport();
		result.setPatronage(patronage);
		result.setCreationMoment(creationMoment);
		
		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;
		
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "javax.validation.constraints.AssertTrue.message");
	
		if (!errors.hasErrors("memorandum")) {
			errors.state(request, SpamDetector.error(entity.getMemorandum(),  this.repository.getSystemConfiguration()), "memorandum", "any.form.error.spam");
		}
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		assert request != null;
		assert entity != null;
		
		Date creationMoment;
		
		creationMoment = new Date(System.currentTimeMillis() -1);
		entity.setCreationMoment(creationMoment);
		this.repository.save(entity);
	}
	
	
}
