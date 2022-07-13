package acme.features.any.artefact;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.artefact.Artefact;
import acme.entities.artefact.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface AnyArtefactRepository extends AbstractRepository {
	
	
	@Query("select a from Artefact a where a.published = true")
	Collection<Artefact> findManyArtifacts();
	
	@Query("select a from Artefact a where a.id = :id")
	Artefact findArtefactById(int id);
	

	@Query("select a from Artefact a, Quantity q, Toolkit t where q.artefact = a and q.toolkit=t and t.id = :toolkitId and a.published = true")
	Collection<Artefact> findToolsAndComponetsByToolkitId(int toolkitId);

	@Query("select a from Artefact a where a.id = :id and a.published = true")
	Artefact findArtefactPublishedById(int id);
	
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findToolkitById(int id);
	
	@Query("select i from Inventor i where i.userAccount.username = :username")
	Inventor findInventorIdById(String username);
	
	
	@Query("select q from Quantity q where q.artefact.id = :artefactId and q.toolkit.id = :toolkitId")
	Quantity findQuantityByArtefactIdAndToolkitId(int artefactId, int toolkitId);

	
}
