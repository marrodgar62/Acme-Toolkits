package acme.testing.administrator.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorSystemConfigurationUpdateTest extends TestHarness{

	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/system-configuration/update-system.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdateSystemConfigurationTest(final int recordIndex, final String currency, final String currencies,  final String weakThreshold, final String strongThreshold) {

		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "System Configuration");
		super.checkFormExists();
		
		super.clickOnButton("Edit");
		
		super.fillInputBoxIn("currency", currency);
		super.fillInputBoxIn("currencies", currencies);
		super.fillInputBoxIn("weakThreshold", weakThreshold);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.clickOnSubmit("Edit");
		
		super.checkFormExists();
		super.checkInputBoxHasValue("currency", currency);
		super.checkInputBoxHasValue("currencies", currencies);
		super.checkInputBoxHasValue("weakThreshold", weakThreshold);
		super.checkInputBoxHasValue("strongThreshold", strongThreshold);
		
		
		super.signOut();

		
	}

	

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/system-configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeUpdateSystemConfigurationTest(final int recordIndex, final String currency, final String currencies,  final String weakThreshold, final String strongThreshold) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "System Configuration");
		super.checkFormExists();
		
		super.clickOnButton("Edit");
		
		super.fillInputBoxIn("currency", currency);
		super.fillInputBoxIn("currencies", currencies);
		super.fillInputBoxIn("weakThreshold", weakThreshold);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.clickOnSubmit("Edit");
		
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/system-configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativeUpdatePatronSystemConfigurationTest(final int recordIndex, final String currency, final String currencies,  final String weakThreshold, final String strongThreshold) {

		super.signIn("patron1", "patron1");
		super.navigate("/administrator/system-configuration/update");
		super.checkPanicExists();

		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/system-configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void negativeUpdateInventorSystemConfigurationTest(final int recordIndex, final String currency, final String currencies,  final String weakThreshold, final String strongThreshold) {

		super.signIn("inventor1", "inventor1");
		super.navigate("/administrator/system-configuration/update");
		super.checkPanicExists();

		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/system-configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void negativeUpdateAnonymousSystemConfigurationTest(final int recordIndex, final String currency, final String currencies,  final String weakThreshold, final String strongThreshold) {

		
		super.navigate("/administrator/system-configuration/update");
		super.checkPanicExists();

		
	}
}
