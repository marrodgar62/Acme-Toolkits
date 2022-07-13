package acme.features.inventor.patronagereports;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patonages.Patronages;
import acme.entities.patronageReport.PatronageReport;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorPatronageReportsRepository  extends AbstractRepository {
	@Query("Select pr from PatronageReport pr where pr.id = :patronageReportId")
	PatronageReport findPatronageReportById(int patronageReportId);
	
	
	@Query("select distinct pr from PatronageReport pr join Patronages p on pr.patronage.id = p.id join Inventor i on i.id = p.inventor.id where pr.patronage.id = :patronageId and i.id = :inventorId ")
	Collection<PatronageReport> findManyPatronagesReportsByPatronageAndInventorId(int patronageId, int inventorId);	

	@Query("Select i from Inventor i, Patronages p where p.inventor = i and p.id = :patronageId")
	Inventor findInventorByPatronageId(int patronageId);
	
	@Query("Select p.inventor from PatronageReport pr join Patronages p on pr.patronage.id= p.id where pr.id = :patronageReportId")
	Inventor findInventorByPatronageReport(int patronageReportId);
	
	@Query("Select p from Patronages p where p.id = :patronageId")
	Patronages findPatronageById(int patronageId);
	
	@Query("select sc from SystemConfiguration sc")
	SystemConfiguration getSystemConfiguration();
	
}
