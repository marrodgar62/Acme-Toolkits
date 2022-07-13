package acme.testing.inventor.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronagesAcceptTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronages/update-accept-status.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronageInventorpositiveAcceptTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My Patronages");
		super.checkListingExists();
		super.sortListing(1, "desc");
		
		super.checkColumnHasValue(recordIndex, 1, code);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("status", "PROPOSED");
		super.checkSubmitExists("Accept");
		super.checkSubmitExists("Denied");
		super.clickOnSubmit("Accept");
		
		super.checkListingExists();
		super.sortListing(1, "desc");
		
		super.checkColumnHasValue(recordIndex, 1, code);
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("initPeriod", initPeriod);
		super.checkInputBoxHasValue("finalPeriod", finalPeriod);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("initPeriod", initPeriod);
		super.checkInputBoxHasValue("patronUsername", username);
		super.checkInputBoxHasValue("patronCompany", company);
		
		super.signOut();
	}
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronages/update-accept-status.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativePatronageInventorBadStatusTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My Patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.clickOnListingRecord(1);
		super.checkFormExists();
		super.checkNotSubmitExists("Accept");
		super.checkNotSubmitExists("Denied");		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronages/update-accept-status.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativePatronageInventorBadDateTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username,
		final String company) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "My Patronages");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.clickOnListingRecord(0);
		super.checkFormExists();
		super.checkSubmitExists("Accept");
		super.checkSubmitExists("Denied");
		super.clickOnSubmit("Accept");
		
		super.checkErrorsExist();
		
	}
	


}
