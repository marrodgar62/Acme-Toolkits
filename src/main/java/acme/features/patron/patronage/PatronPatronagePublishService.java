package acme.features.patron.patronage;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronPatronagePublishService implements AbstractUpdateService<Patron, Patronages> {

	@Autowired
	protected PatronPatronageRepository repository;
	
	@Override
	public boolean authorise(final Request<Patronages> request) {
		assert request != null;
		
		boolean result;
		result = request.getPrincipal().hasRole(Patron.class);
		
		return result;
	}

	@Override
	public void bind(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code","status", "legalStuff", "budget", "initPeriod", "finalPeriod", "link");
	
	}

	@Override
	public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "status", "legalStuff", "budget", "initPeriod", "finalPeriod", "link");

		

	}
	
	@Override
	public void validate(final Request<Patronages> request, final Patronages entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("code")) {
			Patronages exists;
			Patronages oldPatronage;
			oldPatronage = this.repository.findOneById(entity.getId());
			exists = this.repository.findPatronageByCode(entity.getCode());
			
			errors.state(request, exists == null || Objects.equals(exists.getCode(), oldPatronage.getCode()), "code", "patron.patronages.form.error.duplicated-code");
		}
		
		if(!errors.hasErrors("budget")) {
			Double budget;
			
			budget = entity.getBudget().getAmount();
			errors.state(request, budget != null && budget > 0, "code", "patron.patronages.form.error.budget-negative");
		}
		
		if(!errors.hasErrors("initPeriod")) {
			Calendar actualDate;
			Date prueba;

			actualDate = new GregorianCalendar();
			actualDate.add(Calendar.MONTH, 1);
			prueba = actualDate.getTime();
			
			errors.state(request, entity.getInitPeriod() != null && entity.getInitPeriod().after(prueba), "initPeriod", "patron.patronages.form.error.initPeriod-too-close");
		}
		
		if (!errors.hasErrors("finalPeriod")) {
			Date finalPeriod;
			Date initialPeriod;
			Calendar monthDate;
			Date prueba;
			
			initialPeriod = entity.getInitPeriod();
			finalPeriod = entity.getFinalPeriod();
			monthDate = new GregorianCalendar();
			monthDate.setTime(initialPeriod);
			monthDate.add(Calendar.MONTH, 1);
			
			prueba = monthDate.getTime();
			
			errors.state(request, finalPeriod != null && finalPeriod.after(prueba), "finalPeriod", "patron.patronages.form.error.finalPeriod-too-close");
		}
	
		
	}

	@Override
	public void update(final Request<Patronages> request, final Patronages entity) {
		assert request != null;
		assert entity != null;
		
		entity.setPublished(true);
		this.repository.save(entity);
		
	}

	@Override
	public Patronages findOne(Request<Patronages> request) {
		assert request != null;

		Patronages result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
