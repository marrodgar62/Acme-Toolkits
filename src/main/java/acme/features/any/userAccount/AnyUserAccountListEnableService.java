package acme.features.any.userAccount;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.UserAccount;
import acme.framework.roles.Any;
import acme.framework.roles.UserRole;
import acme.framework.services.AbstractListService;

@Service
public class AnyUserAccountListEnableService implements AbstractListService<Any, UserAccount> {

	
	
	@Autowired
	protected AnyUserAccountRepository userAccountRepository;

	@Override
	public boolean authorise(final Request<UserAccount> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public Collection<UserAccount> findMany(final Request<UserAccount> request) {
		assert request != null;

		Collection<UserAccount> result;
		
		result = this.userAccountRepository.findEnableUserAccounts();
		for (final UserAccount userAccount : result) {
			userAccount.getRoles().forEach(r -> {;});
		}
		return result;
	}

	@Override
	public void unbind(final Request<UserAccount> request, final UserAccount entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Collection<UserRole> roles;
		final List<String> rolesAuthorityName = new ArrayList<String>();
			
		roles = entity.getRoles();
		for (final UserRole rol : roles) {
			rolesAuthorityName.add(rol.getAuthorityName());
	}
		model.setAttribute("rol", rolesAuthorityName);
		request.unbind(entity, model, "username", "identity.name", "identity.surname", "identity.email");
	}
	
	
}
