package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronPatronageReportListService implements AbstractListService<Patron, PatronageReport>{

	@Autowired
	protected PatronPatronageReportRepository repository;
	
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		boolean result;
		int patronageId;
		Principal principal;
		
		
		patronageId = request.getModel().getInteger("id");
		principal = request.getPrincipal();
		final Patron patron = this.repository.findPatronByPatronageId(patronageId);
		
		result = principal.getActiveRoleId()==patron.getId();
			
		return result;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		assert request != null;

		Collection<PatronageReport> result;
		int patronId;
		int patronageId;
		
		patronageId = request.getModel().getInteger("id");
		patronId = request.getPrincipal().getActiveRoleId();
		

		result = this.repository.findManyPatronagesReportsByPatronageAndPatronId(patronageId, patronId);

		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "creationMoment","sequenceNumber","link");
		
	}

}
