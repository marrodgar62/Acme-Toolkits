package acme.forms;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		int numberOfComponents;
		
		int numberOfTools;
		
		Map<Pair<String,String>,Double>avgRetailPriceOfComponents;
		
		Map<Pair<String,String>,Double>deviationRetailPriceOfComponents;
		
		Map<Pair<String,String>,Double>minRetailPriceOfComponents;
		
		Map<Pair<String,String>,Double>maxRetailPriceOfComponents;
		
		Map<String,Double> avgRetailPriceOfTools;
		
		Map<String,Double> deviationRetailPriceOfTools;
		
		Map<String,Double> maxRetailPriceOfTools;
		
		Map<String,Double> minRetailPriceOfTools;
		
		int numberOfProposedPatronages;
		
		int numberOfAcceptedPatronages;
		
		int numberOfDeniedPatronages;
		
		Map<String,Double> avgBudgetByStatus;
		
		Map<String,Double> deviationBudgetByStatus;
		
		Map<String,Double> minBudgetByStatus;
		
		Map<String,Double> maxBudgetByStatus;
}

