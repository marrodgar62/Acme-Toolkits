package acme.features.administrator.announcement;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorAnnouncementRepository extends AbstractRepository{
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration getSystemConfiguration();
}
