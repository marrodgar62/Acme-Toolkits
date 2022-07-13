package acme.features.inventor.toolkits;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorToolkitsRepository extends AbstractRepository{

	@Query("select distinct a from Toolkit t join Quantity q on q.toolkit.id  = t.id join Artefact a on a.id = q.artefact.id where t.id  = :id")
	Collection<Artefact> artefactByToolkitId(int id);

	@Query("select distinct a from Toolkit t join Quantity q on q.toolkit.id  = t.id join Artefact a on a.id = q.artefact.id where t.id  = :id")
	Collection<Artefact> findComponentsAndToolsByToolkitId(int id);
	
	@Query("select distinct q from Toolkit t join Quantity q on q.toolkit.id = t.id where t.id = :id")
	Collection<Quantity> findQuantityByToolkit(int id);
	

	////////////////////////////////////////////////////// Cambios despues de la relacion toolkit -> inventor

	@Query("Select c from SystemConfiguration c")
	SystemConfiguration findSystemConfuration();
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findToolkitById(int id);
	
	@Query("select t from Toolkit t")
	Collection<Toolkit>  findAllToolkits();
	
	@Query("select distinct t from Toolkit t where t.inventor.id = :id")
	Collection<Toolkit> findToolkitsByInventorId(int id);

	@Query("select t.inventor.id from Toolkit t where t.id = :id")
	Integer findInventorIdByToolkitId(int id);
	
	
	@Query("Select a from Artefact a where a.id = :id")
	Artefact findArtefactById(int id);
	
	@Query("select i from Inventor i where i.id = :id")
	Inventor findOneInventorById(int id);

	@Query ("select a from Artefact a where  a.published = true")
	Collection<Artefact> findArtefactsPublished();

	@Query("select q from Toolkit t, Quantity q, Artefact a where a.id = :artefactId and t.id = :toolkitId and q.toolkit = t and q.artefact = a")
	Quantity findQuantityByToolkitAndArtefact(int toolkitId, int artefactId);
	
	@Query("select a from Toolkit t, Quantity q, Artefact a where t.id = :toolkitId and q.toolkit = t and q.artefact = a")
	Collection<Artefact> findArtefactsByToolkit(int toolkitId);
	
	
	@Query("select a from Toolkit t, Quantity q, Artefact a where t.id = :toolkitId and q.toolkit = t and q.artefact = a  and a.type = acme.entities.artefact.ArtefactType.TOOL")
	Collection<Artefact> findToolsByToolkit(int toolkitId);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration getSystemConfiguration();
}
