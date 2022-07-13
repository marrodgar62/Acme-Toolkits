package acme.features.administrator.systemConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;


@Service
public class AdministratorSystemConfigurationShowService implements AbstractShowService<Administrator, SystemConfiguration> {

	@Autowired
	protected AdministratorSystemConfigurationRepository repository;
	
	@Override
	public boolean authorise(final Request<SystemConfiguration> request) {
		assert request != null;

		return true;
	}

	@Override
	public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
		assert request != null;

		SystemConfiguration result;

		result = this.repository.getSystemConfiguration();

		return result;
	}

	@Override
	public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String allStrongTerms = this.repository.getSystemConfiguration().getAllStrongTerms();
		final String allWeakTerms = this.repository.getSystemConfiguration().getAllWeakTerms();
		model.setAttribute("allStrongTerms", allStrongTerms);
		model.setAttribute("allWeakTerms", allWeakTerms);
		
		
		request.unbind(entity, model, "currency","currencies",
				"weakThreshold","strongThreshold");
		
	}

}
