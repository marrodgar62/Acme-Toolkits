package acme.features.any.userAccount;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;


@Repository
public interface AnyUserAccountRepository extends AbstractRepository{

	@Query("Select ua from UserAccount ua where ua.id = :id")
	UserAccount findOneUserAccountById(int id);
	
	@Query("SELECT distinct ua FROM UserAccount ua JOIN ua.roles r WHERE ua.enabled = true AND "
		+  "Administrator NOT IN (SELECT type(r) FROM UserAccount ua2 JOIN ua2.roles r "
		+  "WHERE ua2.id = ua.id)")
	Collection<UserAccount> findEnableUserAccounts();

	


}
