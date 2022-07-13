package acme.features.patron.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageReportShowService implements AbstractShowService<Patron, PatronageReport> {

	@Autowired
	protected PatronPatronageReportRepository repository;
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		
		boolean result;
		int patronageReportId;
		Principal user;
		PatronageReport patronageReport;
		int patronId;
		
		
		patronageReportId = request.getModel().getInteger("id");
		patronageReport = this.repository.findPatronageReportById(patronageReportId);
		user = request.getPrincipal();
		patronId = patronageReport.getPatronage().getPatron().getId();
		
		result = (patronId == user.getActiveRoleId());
		
		return result;
		
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;
		
		final PatronageReport result;
		
		int patronageReportId;
		
		patronageReportId = request.getModel().getInteger("id");
		
		result = this.repository.findPatronageReportById(patronageReportId);
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "creationMoment","sequenceNumber","memorandum","link");
	}

}
