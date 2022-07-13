package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveInventorPatronageReportTest(final int recordIndex, final String creationMoment, final String memorandum, final String link) {

		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My Patronages");
		super.clickOnListingRecord(0);
		super.clickOnButton("Patronage Reports");
		super.checkListingExists();
		super.sortListing(1, "asc");



		//Revisar que la cabecera esta bien
		super.checkColumnHasValue(recordIndex, 0, creationMoment);
		super.checkColumnHasValue(recordIndex, 1, memorandum);
		super.checkColumnHasValue(recordIndex, 2, link);

		//Revisamos que el show va bien y tiene todo
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		

	}
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void NegativeAnonymousPatronageReportListTest(final int recordIndex, final String creationMoment, final String memorandum, final String link) {
		
		
		super.navigate("/inventor/patronage-report/list-mine-reports");
		
		super.checkPanicExists();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativePatronPatronageReportListTest(final int recordIndex, final String creationMoment, final String memorandum, final String link) {
		
		super.signIn("patron1", "patron1");
		
		super.navigate("/inventor/patronage-report/list-mine-reports");
		
		super.checkPanicExists();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativeAdministratorPatronageReportListTest(final int recordIndex, final String creationMoment, final String memorandum, final String link) {
		
		super.signIn("administrator", "administrator");
		
		super.navigate("/inventor/patronage-report/list-mine-reports");
		
		super.checkPanicExists();
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void NegativeOtherInventorPatronageReportListTest(final int recordIndex, final String creationMoment, final String memorandum, final String link) {

		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My Patronages");
		super.clickOnListingRecord(0);
		super.clickOnButton("Patronage Reports");;
        super.checkListingExists();
        super.sortListing(0, "asc");
        final String query = super.getCurrentQuery();

        super.signOut();


        super.signIn("inventor2", "inventor2");
        final String queryNueva = query.substring(1);
        super.navigate("/inventor/patronage-report/list-mine-reports",queryNueva);
        super.checkPanicExists();

        super.signOut();
		
		
	}
	// Ancillary methods ------------------------------------------------------
}
