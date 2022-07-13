package acme.features.inventor.toolkits;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.artefact.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;


@Service
public class InventorToolkitsDeleteService implements AbstractDeleteService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitsRepository repository;
	
	@Override
	public boolean authorise(Request<Toolkit> request) {
		assert request != null;
		
		
		Toolkit result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);
	
		Collection<Toolkit> toolkits = this.repository.findToolkitsByInventorId(request.getPrincipal().getActiveRoleId());
		boolean isMine = toolkits.stream().anyMatch(x -> x.getId() == request.getModel().getInteger("id"));
		
		return !result.isPublished() && isMine;
	}

	@Override
	public void bind(Request<Toolkit> request, Toolkit entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "code","title");
		
	}

	@Override
	public void unbind(Request<Toolkit> request, Toolkit entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code","title");
		
	}

	@Override
	public Toolkit findOne(Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);
		
		return result;
	}

	@Override
	public void validate(Request<Toolkit> request, Toolkit entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(Request<Toolkit> request, Toolkit entity) {
		assert request != null;
		assert entity != null;
		Collection<Quantity> quantityCollection;
		quantityCollection = this.repository.findQuantityByToolkit(entity.getId());
		for(Quantity q : quantityCollection) {
			this.repository.delete(q);
		}
		this.repository.delete(entity);
	}
}
