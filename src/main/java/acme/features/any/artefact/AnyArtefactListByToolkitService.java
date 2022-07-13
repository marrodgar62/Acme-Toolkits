package acme.features.any.artefact;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;


@Service
public class AnyArtefactListByToolkitService implements AbstractListService<Any, Artefact>{

	@Autowired
	protected AnyArtefactRepository repository;

	@Override
	public boolean authorise(final Request<Artefact> request) {
		assert request != null;
		int masterId;
		Toolkit toolkit;
		
		
		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findToolkitById(masterId);
		
		
		if(!toolkit.isPublished()) {
			if(!request.getPrincipal().hasRole(Inventor.class)) {
				return false;
			}
			Inventor inventor = this.repository.findInventorIdById(request.getPrincipal().getUsername());
			return toolkit.getInventor().getId() == inventor.getId();
		}
	
		return true;
	}


	@Override
	public Collection<Artefact> findMany(final Request<Artefact> request) {
		assert request != null;
		
		Collection<Artefact> result;
		final int masterId;
		
	
		masterId = request.getModel().getInteger("masterId");
		result = this.repository.findToolsAndComponetsByToolkitId(masterId);

		
		return result;
		
	}

	@Override
	public void unbind(final Request<Artefact> request, final Artefact entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int toolkit;
		
		toolkit = request.getModel().getInteger("masterId");
		request.unbind(entity, model, "type", "name", "code", "technology",
			"description","retailPrice", "moreInfo");
		
		Quantity quantity;
		quantity = this.repository.findQuantityByArtefactIdAndToolkitId(entity.getId(),toolkit);
		model.setAttribute("quantity", quantity.getNumber());
	}
	
}
