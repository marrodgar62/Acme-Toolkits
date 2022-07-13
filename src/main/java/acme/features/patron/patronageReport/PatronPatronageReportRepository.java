package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronageReport.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageReportRepository extends AbstractRepository{
	
	@Query("select p from PatronageReport p where p.patronage.patron.id = :id")
	Collection<PatronageReport> findManyPatronageReportsByPatronId(int id);
	
	@Query("select p from PatronageReport p where p.id = :id")
	PatronageReport findPatronageReportById(int id);
	
	@Query("select distinct pr from PatronageReport pr join Patronages p on pr.patronage.id = p.id join Patron pt on pt.id = p.patron.id where pr.patronage.id = :patronageId and pt.id = :patronId ")
	Collection<PatronageReport> findManyPatronagesReportsByPatronageAndPatronId(int patronageId, int patronId);	
	
	@Query("Select p.patron from Patronages p where p.id = :patronageId")
	Patron findPatronByPatronageId(int patronageId);
	

}
