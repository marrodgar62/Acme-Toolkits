package acme.features.inventor.patronagereports;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportsListMineService implements AbstractListService<Inventor, PatronageReport>{
	
	@Autowired
	protected InventorPatronageReportsRepository repository;
	
	
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		boolean result;
		
		int patronageId;
		Principal principal;
		
		patronageId = request.getModel().getInteger("id");
		principal = request.getPrincipal();
		final Inventor inventor = this.repository.findInventorByPatronageId(patronageId);
		
		result = principal.getActiveRoleId()==inventor.getId();		
		return result;
	}

	@Override
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) {
		
		assert request != null;
		
		
		final Collection<PatronageReport> result;
		Principal principal;
		int patronageId;
		
		patronageId = request.getModel().getInteger("id");
		principal = request.getPrincipal();
		
		result = this.repository.findManyPatronagesReportsByPatronageAndInventorId(patronageId, principal.getActiveRoleId());
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "creationMoment", "memorandum", "link");
		model.setAttribute("patronageId", request.getModel().getInteger("id"));
		
	}

}
