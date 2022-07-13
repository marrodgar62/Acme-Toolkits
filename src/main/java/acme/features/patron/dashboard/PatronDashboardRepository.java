package acme.features.patron.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface PatronDashboardRepository extends AbstractRepository{

	@Query("select count(p) from Patronages p where p.status = 0 and p.patron.id = :patronId")
	int numberOfProposedPatronages(int patronId);
	
	@Query("select count(p) from Patronages p where p.status = 1 and p.patron.id = :patronId")
	int numberOfAcceptedPatronages(int patronId);
	
	@Query("select count(p) from Patronages p where p.status = 2 and p.patron.id = :patronId")
	int numberOfDeniedPatronages(int patronId);
	
	@Query("select p.status, p.budget.currency, avg(p.budget.amount) from Patronages p where p.patron.id = :patronId group by p.budget.currency, p.status")
	List<String> averageBudgetOfPatronageByCurrencyAndStatus(int patronId);
	
	@Query("select p.status, p.budget.currency, stddev(p.budget.amount) from Patronages p where p.patron.id = :patronId group by p.budget.currency, p.status")
	List<String> deviationBudgetOfPatronageByCurrencyAndStatus(int patronId);
	
	@Query("select p.status, p.budget.currency, min(p.budget.amount) from Patronages p where p.patron.id = :patronId group by p.budget.currency, p.status")
	List<String> minimumBudgetOfPatronageByCurrencyAndStatus(int patronId);
	
	@Query("select p.status, p.budget.currency, max(p.budget.amount) from Patronages p where p.patron.id = :patronId group by p.budget.currency, p.status")
	List<String> maximumBudgetOfPatronageByCurrencyAndStatus(int patronId);

}
