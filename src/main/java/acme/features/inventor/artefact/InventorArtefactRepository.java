package acme.features.inventor.artefact;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorArtefactRepository extends AbstractRepository{
	
	
	@Query("select a from Artefact a where a.id = :id")
	Artefact findArtefactById(int id);
	
	@Query ("select a from Artefact a where a.inventor.id = :inventorId")
	Collection<Artefact> findArtefactsFromInventor(int inventorId);

	@Query("select distinct a from Toolkit t join Quantity q on q.toolkit.id  = t.id join Artefact a on a.id = q.artefact.id where t.id  = :id")
	Collection<Artefact> findComponentsAndToolsByToolkitId(int id);
	
	@Query("select a.inventor.id from Artefact a where a.id = :id")
	Integer findInventorIdByArtefactId(int id);
	
	@Query("select distinct a.id from Toolkit t join Quantity q on q.toolkit.id  = t.id join Artefact a on a.id = q.artefact.id where t.id  = :id")
	List<Integer> findArtefactIdByToolkitId(int id);
	
	@Query("select a from Artefact a where a.code = :code")
	Artefact findOneByCode(String code);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findInventorIdById(int id);
	
	@Query("select q from Quantity q where q.artefact.id = :id")
	Quantity findQuantityByArtefactId(int id);
	
	
	@Query("select q from Quantity q where q.artefact.id = :artefactId and q.toolkit.id = :toolkitId")
	Quantity findQuantityByArtefactIdAndToolkitId(int artefactId, int toolkitId);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration getSystemConfiguration();
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findToolkitById(int id);
	
	@Query("select currencies from SystemConfiguration c")
	String findAllCurrencies();
	
}
