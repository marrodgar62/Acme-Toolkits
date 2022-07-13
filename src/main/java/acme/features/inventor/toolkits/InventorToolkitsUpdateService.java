package acme.features.inventor.toolkits;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkit.Toolkit;
import acme.features.spam.SpamDetector;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorToolkitsUpdateService implements AbstractUpdateService<Inventor, Toolkit>{

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
		
		request.bind(entity, errors, "code", "title", "description", "assemblyNotes", "link");
		
	}

	@Override
	public void unbind(Request<Toolkit> request, Toolkit entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "link");
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

		if(!errors.hasErrors("code")) {
			boolean isDuplicatedCode;
			isDuplicatedCode = this.repository.findAllToolkits().stream().noneMatch(x-> x.getCode().equals(entity.getCode()) && x.getId() != entity.getId());
			errors.state(request, isDuplicatedCode , "code", "inventor.toolkit.form.label.code.duplicate.error");
		}
		if (!errors.hasErrors("title")) {
			errors.state(request, SpamDetector.error(entity.getTitle(),  this.repository.getSystemConfiguration()), "title", "any.form.error.spam");
		}
		if (!errors.hasErrors("description")) {
			errors.state(request, SpamDetector.error(entity.getDescription(),  this.repository.getSystemConfiguration()), "description", "any.form.error.spam");
		}
		if (!errors.hasErrors("assemblyNotes")) {
			errors.state(request, SpamDetector.error(entity.getAssemblyNotes(),  this.repository.getSystemConfiguration()), "assemblyNotes", "any.form.error.spam");
		}
	}

	@Override
	public void update(Request<Toolkit> request, Toolkit entity) {
		assert request != null;
		assert entity != null;
	
		
		this.repository.save(entity);
	}
	
	

}