package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patonages.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	Map<PatronageStatus, Integer>		numberOfPatronageByStatus;
	
	Map<Pair<PatronageStatus, String>, Double> averageBudgetOfPatronageByCurrencyAndStatus;

	Map<Pair<PatronageStatus, String>, Double> deviationBudgetOfPatronageByCurrencyAndStatus;

	Map<Pair<PatronageStatus, String>, Double> minimumBudgetOfPatronageByCurrencyAndStatus;

	Map<Pair<PatronageStatus, String>, Double> maximumBudgetOfPatronageByCurrencyAndStatus;

	
	

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------{

}
