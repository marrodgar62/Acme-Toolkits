package acme.features.inventor.toolkits;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artefact.Artefact;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitsPublishService implements AbstractUpdateService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitsRepository repository;

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		
		
		
		final Collection<Toolkit> toolkits = this.repository.findToolkitsByInventorId(request.getPrincipal().getActiveRoleId());
		return toolkits.stream().anyMatch(x -> x.getId() == request.getModel().getInteger("id"));
	
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "link", "published");
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link", "published");
		
		
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
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final Collection<Artefact> artefacts = this.repository.findComponentsAndToolsByToolkitId(entity.getId());
		
		if(artefacts == null || artefacts.isEmpty()){
			errors.state(request, artefacts != null && !artefacts.isEmpty() , "*", "inventor.toolkit.published.error.artefacts");
		}
	
	}

	@Override
	public void update(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
	
		
		entity.setPublished(true);
		this.repository.save(entity);
	}
	
	

}