package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;


@Repository
public interface AnyToolkitRepository extends AbstractRepository{
	
	
	@Query("select t from Toolkit t where t.id = :id and t.published=true")
	Toolkit findOneToolkitById(int id);
	
	@Query("select t from Toolkit t where t.published=true")
	Collection<Toolkit> findAllToolkit();
	
	@Query("select a from Artefact a, Quantity q, Toolkit t where q.artefact = a and q.toolkit=t and t.id = :id and t.published=true and a.published=true")
	Collection<Artefact> findArtefactByToolkitId(int id);
	
	@Query("select distinct t from Artefact a, Quantity q, Toolkit t where q.artefact = a and q.toolkit=t and a.name like :artefactName and t.published=true")
	Collection<Toolkit> findAllArtefactByName(String artefactName);
	
	
	@Query("Select c from SystemConfiguration c")
	SystemConfiguration findSystemConfuration();
	
	
	@Query("select distinct q from Toolkit t join Quantity q on q.toolkit.id  = t.id join Artefact a on a.id = q.artefact.id where t.id  = :toolkitId and a.id = :artefactId")
	Quantity findQuantityByToolkitAndArtefact(int toolkitId, int artefactId);
	

}
