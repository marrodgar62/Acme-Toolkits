package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagesListMineTest extends TestHarness{
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronagespatronTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 1, status);
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);
		super.checkColumnHasValue(recordIndex, 3, budget);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("initPeriod", initPeriod);
		super.checkInputBoxHasValue("finalPeriod", finalPeriod);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("initPeriod", initPeriod);
		super.checkInputBoxHasValue("inventorUsername", username);
		super.checkInputBoxHasValue("inventorCompany", company);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void NegativePatronagesListAnonymousTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		
		super.navigate("/patron/patronages/list-mine");
		
		super.checkPanicExists();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativePatronagesListPatronTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		super.signIn("patron1", "patron1");
		
		super.navigate("/patron/patronages/list-mine");
		
		super.checkPanicExists();
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void NegativePatronagesListAdministratorTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		super.signIn("administrator", "administrator");
		
		super.navigate("/patron/patronages/list-mine");
		
		super.checkPanicExists();
		
		super.signOut();
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(60)
	public void NegativePatronagesShowAnonymousTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
        super.clickOnListingRecord(recordIndex);
        final String query = super.getCurrentQuery();

        super.signOut();

      
        final String queryNueva = query.substring(1);
        super.navigate("/patron/patronages/show",queryNueva);
        super.checkPanicExists();

		
		
		super.checkPanicExists();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(70)
	public void NegativePatronagesShowpatronTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
        super.clickOnListingRecord(recordIndex);
        final String query = super.getCurrentQuery();

        super.signOut();

        super.signIn("patron2", "patron2");
        final String queryNueva = query.substring(1);
        super.navigate("/patron/patronages/show",queryNueva);
        super.checkPanicExists();

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(80)
	public void NegativePatronagesShowPatronTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
        super.clickOnListingRecord(recordIndex);
        final String query = super.getCurrentQuery();

        super.signOut();

        super.signIn("patron2", "patron2");
        final String queryNueva = query.substring(1);
        super.navigate("/patron/patronages/show",queryNueva);
        super.checkPanicExists();

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronages/list-patronages.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(90)
	public void NegativePatronagesShowAdministratorTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Patron", "My patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
        super.clickOnListingRecord(recordIndex);
        final String query = super.getCurrentQuery();

        super.signOut();

        super.signIn("administrator", "administrator");
        final String queryNueva = query.substring(1);
        super.navigate("/patron/patronages/show",queryNueva);
        super.checkPanicExists();

		super.signOut();
	}
}
