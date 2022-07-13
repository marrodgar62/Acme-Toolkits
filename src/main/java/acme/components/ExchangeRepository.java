package acme.components;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.systemConfiguration.ExchangeRate;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ExchangeRepository extends AbstractRepository {
	
	@Query("Select er from ExchangeRate er where er.baseTarget like :baseTarget")
	ExchangeRate findExchangeRateByCurrency(String baseTarget);
	
	@Query("Select c from SystemConfiguration c")
	SystemConfiguration findSystemConfuration();
}
