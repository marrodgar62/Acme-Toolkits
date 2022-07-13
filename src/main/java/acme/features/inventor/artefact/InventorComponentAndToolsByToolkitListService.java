package acme.features.inventor.artefact;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorComponentAndToolsByToolkitListService implements AbstractListService<Inventor, Artefact>{

	@Autowired
	protected InventorArtefactRepository repository;

	@Override
	public boolean authorise(final Request<Artefact> request) {
		assert request != null;

		final boolean result;
		int masterId;
		Toolkit toolkit;
		Integer inventorId;
		final Principal principal;
		
		masterId = request.getModel().getInteger("masterId");
		

		toolkit = this.repository.findToolkitById(masterId);
		
		inventorId = toolkit.getInventor().getId();
		
		principal = request.getPrincipal();
		result = principal.getActiveRoleId() == inventorId;
			
		return result;
	}

	@Override
	public Collection<Artefact> findMany(final Request<Artefact> request) {
		assert request != null;

		Collection<Artefact> result;

		int id;
		
		id = request.getModel().getInteger("masterId");
		result = this.repository.findComponentsAndToolsByToolkitId(id);
		return result;
	}
	
	@Override
	public void unbind(final Request<Artefact> request, final Artefact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int toolkitId;
		
		toolkitId = request.getModel().getInteger("masterId");
		
		
		request.unbind(entity, model, "type", "name", "code", "technology",
			"description","retailPrice", "moreInfo","published");
		
		Quantity quantity;
		quantity = this.repository.findQuantityByArtefactIdAndToolkitId(entity.getId(),toolkitId);
		model.setAttribute("quantity", quantity.getNumber());
		
	}
	
}
