package acme.testing.authenticated.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedSystemConfigurationTest extends TestHarness{
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/system-configuration/show-system-configuration.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveSystemConfigurationTest(final int recordIndex, final String currency, final String currencies) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Authenticated", "System Configuration");
		super.checkFormExists();
		
		
		super.checkInputBoxHasValue("currency", currency);
		super.checkInputBoxHasValue("currencies", currencies);
	}
}
