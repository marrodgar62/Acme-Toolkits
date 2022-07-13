package acme.features.authenticated.systemConfiguration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;


@Repository
public interface AuthenticatedSystemConfigurationRepository extends AbstractRepository{
	
	
	@Query("Select sc from SystemConfiguration sc")
	SystemConfiguration find();

}
