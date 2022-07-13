package acme.features.patron.patronage;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patonages.Patronages;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;
import acme.roles.Patron;

@Repository
public interface PatronPatronageRepository extends AbstractRepository{
	
	
	@Query("select p from Patronages p where p.id = :id")
	Patronages findOneById(int id);

	@Query("select p from Patronages p where p.patron.id = :id")
	Collection<Patronages> findOwnPatronages(int id);

	@Query("Select p from Patron p where p.userAccount.id = :id")
	Patron findPatronByUserAccountId(int id);
	
	@Query("Select p from Patronages p where p.code like :code")
	Patronages findPatronageByCode(String code);

	@Query("Select i from Inventor i where i.userAccount.username = :userName")
	Inventor findInventorByUserName(String userName);
	
	@Query("Select i from Inventor i where i.id = :id")
	Inventor findInventorById(int id);
	
	@Query("Select i from Inventor i")
	Collection<Inventor> findAllInventors();
	
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration getSystemConfiguration();

	@Query("select currencies from SystemConfiguration c")
	String findAllCurrencys();
}
