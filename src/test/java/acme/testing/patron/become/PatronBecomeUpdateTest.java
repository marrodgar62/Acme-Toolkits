package acme.testing.patron.become;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronBecomeUpdateTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/become/become-update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void updateTest(final int recordIndex, final String company, final String statement, final String link) {
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Account", "Patron data");

		super.checkFormExists();
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		
		super.clickOnMenu("Account", "Patron data");
		super.checkInputBoxHasValue("company",company);
		super.checkInputBoxHasValue("statement",statement);
		super.checkInputBoxHasValue("link", link);		
		
		super.signOut();
	} 
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/become/become-update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void updateTestNegative(final int recordIndex, final String company, final String statement, final String link) {
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Account", "Patron data");

		super.checkFormExists();
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Update");
		super.checkErrorsExist();	
		
		super.signOut();
	}
}
