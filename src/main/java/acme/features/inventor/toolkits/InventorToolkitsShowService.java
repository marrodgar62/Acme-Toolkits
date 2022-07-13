package acme.features.inventor.toolkits;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.ExchangeService;
import acme.entities.artefact.Artefact;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitsShowService implements AbstractShowService<Inventor, Toolkit>{

	// Internal state --------------------------------------------------------------------
	
	@Autowired
	protected ExchangeService exchangeService;
	
	
	@Autowired
	protected InventorToolkitsRepository repository;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		final boolean result;
		int masterId;
		Integer inventorId;
		final Principal principal;
		Toolkit toolkit;
		masterId = request.getModel().getInteger("id");
		toolkit = this.repository.findToolkitById(masterId);
		inventorId = this.repository.findInventorIdByToolkitId(toolkit.getId());
		principal = request.getPrincipal();
		result = (principal.getActiveRoleId() == inventorId);
		return result;
	}

	
	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);
		
		return result;
	}
	
	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Collection<Artefact> artefacts;
		int id;
		SystemConfiguration systemConfiguration;
		id = request.getModel().getInteger("id");
		artefacts = this.repository.artefactByToolkitId(id);

		systemConfiguration = this.repository.findSystemConfuration();
	
		
		
		// Model attributes
		

		request.unbind(entity, model, "code","title","description","assemblyNotes","link", "published");
		model.setAttribute("toolkitId", entity.getId());
		if(systemConfiguration != null && systemConfiguration.getCurrency() != null) {
			if(!artefacts.isEmpty()) {
				final Double price = artefacts.stream()
						.map(x -> this.exchangeService.exchangeMoneySystemConfiguration(x.getRetailPrice()).getAmount()*this.repository.findQuantityByToolkitAndArtefact(entity.getId(), x.getId()).getNumber())
						.reduce(0.0, (a, b) -> a + b);
				final Money money =  new Money();
				money.setAmount(price);	
				money.setCurrency(systemConfiguration.getCurrency());
				model.setAttribute("price",money);
			}else {
				final Money money =  new Money();
				money.setAmount(0.0);
				money.setCurrency(systemConfiguration.getCurrency());
				model.setAttribute("price",money);
			}
		}
	}
}
