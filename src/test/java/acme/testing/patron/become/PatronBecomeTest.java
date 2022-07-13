package acme.testing.patron.become;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronBecomeTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/become/become-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String company, final String statement, final String link) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Account", "Become a patron");

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");
		super.checkErrorsExist();
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/become/become-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveTest(final int recordIndex, final String company, final String statement, final String link) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Account", "Become a patron");

		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Register");

		super.clickOnMenu("Account", "Patron data");
		super.checkInputBoxHasValue("company",company);
		super.checkInputBoxHasValue("statement",statement);
		super.checkInputBoxHasValue("link", link);

		super.signOut();
	}
	
	
}
