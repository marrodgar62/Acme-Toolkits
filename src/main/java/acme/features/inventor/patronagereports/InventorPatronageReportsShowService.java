package acme.features.inventor.patronagereports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportsShowService implements AbstractShowService<Inventor, PatronageReport>{
	
	@Autowired
	protected InventorPatronageReportsRepository repository;
		
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		boolean result;
		
		int patronageReportId;
		Principal principal;
		
		patronageReportId = request.getModel().getInteger("id");
		principal = request.getPrincipal();
		final Inventor inventor = this.repository.findInventorByPatronageReport(patronageReportId);
		
		result = principal.getActiveRoleId()==inventor.getId();
			
			
		
		return result;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findPatronageReportById(id);

		return result;
	}


	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "creationMoment", "memorandum", "link");
		
	}

}
