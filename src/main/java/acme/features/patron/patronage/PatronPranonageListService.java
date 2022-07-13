package acme.features.patron.patronage;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;


@Service
public class PatronPranonageListService implements AbstractListService<Patron, Patronages>{


	@Autowired
	private PatronPatronageRepository repository;

	@Override
	public boolean authorise(final Request<Patronages> request) {
		assert request != null; 
		
		return true;
	}

	@Override
	public Collection<Patronages> findMany(final Request<Patronages> request) {
		assert request != null;
		
		Collection<Patronages> result;
		final Principal principal = request.getPrincipal();
		
		result = this.repository.findOwnPatronages(principal.getActiveRoleId());
		if(result == null) {
			return new ArrayList<Patronages>();
		}
		return result;
	}

	@Override
	public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model,"status", "code", "legalStuff", "budget", "published");
		final String inventor = entity.getInventor().getUserAccount().getUsername();
        model.setAttribute("inventor.username", inventor);
	}

}
