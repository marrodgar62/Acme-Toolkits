package acme.features.inventor.patronages;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patonages.Patronages;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorPatronagesRepository  extends AbstractRepository {
		
	@Query("select p from Patronages p where p.inventor.id  = :inventorId and p.published = 1")
	Collection<Patronages> findManyPatronagesByInventorId(int inventorId);
	
	
	@Query("Select p from Patronages p where p.id = :patronageId")
	Patronages findPatronagesById(int patronageId);
	
	@Query("Select p.inventor from Patronages p where p.id = :patronageId")
	Inventor findInventorByPatronageId(int patronageId);
	
	
}
