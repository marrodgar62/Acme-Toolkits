package acme.features.any.toolkit;

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
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;


@Service
public class AnyToolkitShowService implements AbstractShowService<Any, Toolkit>{
	

	@Autowired
	protected ExchangeService exchangeService;
	
	@Autowired
	protected AnyToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);

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
		artefacts = this.repository.findArtefactByToolkitId(id);
		
		systemConfiguration = this.repository.findSystemConfuration();
	
		
		
		// Model attributes
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link");
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
