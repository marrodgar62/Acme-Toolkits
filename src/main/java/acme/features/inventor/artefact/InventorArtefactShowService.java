package acme.features.inventor.artefact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.ExchangeService;
import acme.entities.artefact.Artefact;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorArtefactShowService implements AbstractShowService<Inventor, Artefact>{
	
	// Internal state ---------------------------------------------------------
	
		@Autowired
		protected ExchangeService exchangeService ;
		
		@Autowired
		protected InventorArtefactRepository repository;
			
		@Override
		public boolean authorise(final Request<Artefact> request) {
			assert request != null;
			
			boolean result;
			int artefactId;
			Artefact artefact;
			Principal user;
			int inventorId;
			
			
			artefactId = request.getModel().getInteger("id");
			user = request.getPrincipal();
			artefact = this.repository.findArtefactById(artefactId);
			inventorId = artefact.getInventor().getId();
			
			result = (inventorId == user.getActiveRoleId());
			
			return result;
		}

		@Override
		public Artefact findOne(final Request<Artefact> request) {
			assert request != null;

			Artefact result;
			int id;

			id = request.getModel().getInteger("id");
			result = this.repository.findArtefactById(id);

			return result;
		}

		@Override
		public void unbind(final Request<Artefact> request, final Artefact entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "type", "name", "code", "technology",
				"description","retailPrice", "moreInfo", "published");
			model.setAttribute("moneyExchange", this.exchangeService.exchangeMoneySystemConfiguration(entity.getRetailPrice()));
		}
}