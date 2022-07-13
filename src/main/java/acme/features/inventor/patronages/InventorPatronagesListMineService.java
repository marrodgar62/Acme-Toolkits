package acme.features.inventor.patronages;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patonages.Patronages;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronagesListMineService implements AbstractListService<Inventor, Patronages> {
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronagesRepository repository;

		// AbstractListService<Employer, Job> interface ---------------------------


		@Override
		public boolean authorise(final Request<Patronages> request) {
			assert request != null;

			return true;
		}

		@Override
		public Collection<Patronages> findMany(final Request<Patronages> request) {
			assert request != null;

			Collection<Patronages> result;
			Principal principal;

			principal = request.getPrincipal();
			result = this.repository.findManyPatronagesByInventorId(principal.getActiveRoleId());

			return result;
		}

		@Override
		public void unbind(final Request<Patronages> request, final Patronages entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "status", "code", "legalStuff", "budget", "creationTime", "initPeriod", "finalPeriod", "link");
		}
	
}
