package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.ExchangeService;
import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageShowService implements AbstractShowService<Patron, Patronages>{

	@Autowired
	protected ExchangeService exchangeService ;
	@Autowired
	private PatronPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronages> request) {
		assert request != null;

		final Patronages patronage = this.repository.findOneById(request.getModel().getInteger("id"));
		
		if(patronage.getPatron().getId() == request.getPrincipal().getActiveRoleId()) return true;
		
		return false;
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
	public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "status",  "published", "code", "legalStuff", "budget"
			,"initPeriod", "finalPeriod", "link", "inventor.userAccount.username",
			"inventor.company","inventor.link","inventor.statement");

		model.setAttribute("moneyExchange", this.exchangeService.exchangeMoneySystemConfiguration(entity.getBudget()));
		model.setAttribute("inventorUsername", entity.getInventor().getUserAccount().getUsername());
		model.setAttribute("inventorCompany", entity.getInventor().getCompany());
		model.setAttribute("inventorLink", entity.getInventor().getLink());
		model.setAttribute("inventorStatement", entity.getInventor().getStatement());

	}

}
