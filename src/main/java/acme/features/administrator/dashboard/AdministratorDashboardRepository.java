package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;


@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("select count(p) from Patronages p where p.status = acme.entities.patonages.PatronageStatus.PROPOSED")
	int numberOfProposedPatronages();
	@Query("select count(p) from Patronages p where p.status = acme.entities.patonages.PatronageStatus.ACCEPTED")
	int numberOfAcceptedPatronages();
	@Query("select count(p) from Patronages p where p.status = acme.entities.patonages.PatronageStatus.DENIED")
	int numberOfDeniedPatronages();
	@Query("select count(a) from Artefact a where a.type = acme.entities.artefact.ArtefactType.TOOL")
	int numberOfTools();	
	@Query("select count(a) from Artefact a where a.type = acme.entities.artefact.ArtefactType.COMPONENT")
	int numberOfComponents();	
	
	@Query("select a.retailPrice.currency, avg(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.TOOL group by a.retailPrice.currency")
	List<String> avgRetailPriceOfTools();
	@Query("select a.retailPrice.currency, stddev(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.TOOL group by a.retailPrice.currency")
	List<String> deviationRetailPriceOfTools();
	@Query("select a.retailPrice.currency, min(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.TOOL group by a.retailPrice.currency")
	List<String> minRetailPriceOfTools();
	@Query("select a.retailPrice.currency, min(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.TOOL group by a.retailPrice.currency")
	List<String> maxRetailPriceOfTools();
	
	@Query("select a.retailPrice.currency, a.technology, avg(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.COMPONENT group by a.retailPrice.currency, a.technology")
	List<String> avgRetailPriceOfComponents();
	@Query("select a.retailPrice.currency, a.technology, stddev(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.COMPONENT group by a.retailPrice.currency, a.technology")
	List<String> deviationRetailPriceOfComponents();
	@Query("select a.retailPrice.currency, a.technology, min(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.COMPONENT group by a.retailPrice.currency, a.technology")
	List<String> minRetailPriceOfComponents();
	@Query("select a.retailPrice.currency, a.technology, max(a.retailPrice.amount), a.type from Artefact a where a.type=acme.entities.artefact.ArtefactType.COMPONENT group by a.retailPrice.currency, a.technology")
	List<String> maxRetailPriceOfComponents();
	
	@Query("select p.budget.currency, avg(p.budget.amount), p.status from Patronages p group by p.status")
	List<String> avgBudgetByStatus();
	@Query("select p.budget.currency, stddev(p.budget.amount), p.status from Patronages p group by p.status")
	List<String> deviationBudgetByStatus();
	@Query("select p.budget.currency, min(p.budget.amount), p.status from Patronages p group by p.status")
	List<String> minBudgetByStatus();
	@Query("select p.budget.currency, min(p.budget.amount), p.status from Patronages p group by p.status")
	List<String> maxBudgetByStatus();
}
