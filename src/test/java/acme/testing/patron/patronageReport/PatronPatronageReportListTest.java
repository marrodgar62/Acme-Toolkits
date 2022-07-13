package acme.testing.patron.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageReportListTest extends TestHarness{
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	
	

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronPatronageReportTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum, final String link) {

		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "My patronages");
		super.sortListing(1, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Patronage Reports");
		super.checkListingExists();
		super.sortListing(1, "desc");


		//Revisar que la cabecera esta bien
		//NO SE COMPRUEBA EL SEQUENCENUMBER POR QUE AL IR CAMBIANDO EL ID FALLA EL CSV
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.checkColumnHasValue(recordIndex, 2, link);

		
		//Revisamos que el show va bien y tiene todo
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		final String query = super.getCurrentQuery();
		final String queryNueva = query.substring(1).split("=")[1];
		
		super.checkInputBoxHasValue("sequenceNumber",sequenceNumber+queryNueva);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		
		
	}
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void NegativeAnonymousPatronageReportListTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum, final String link) {
		
		
		super.navigate("/patron/patronage-report/list","id=35");
		
		super.checkPanicExists();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativeInventorPatronageReportListTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum, final String link) {
		
		super.signIn("inventor1", "inventor1");
		
		super.navigate("/patron/patronage-report/list","id=35");
		
		super.checkPanicExists();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativeAdministratorPatronageReportListTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum, final String link) {
		
		super.signIn("administrator", "administrator");
		
		super.navigate("/patron/patronage-report/list","id=35");
		
		super.checkPanicExists();
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage-report/list-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void NegativeOtherPatronPatronageReportListTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum, final String link) {

		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "My patronages");
		super.sortListing(1, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Patronage Reports");
        super.checkListingExists();
        super.sortListing(0, "asc");
        final String query = super.getCurrentQuery();

        super.signOut();


        super.signIn("patron2", "patron2");
        final String queryNueva = query.substring(1);
        super.navigate("/patron/patronage-report/list",queryNueva);
        super.checkPanicExists();

        super.signOut();
		
		
	}
	// Ancillary methods ------------------------------------------------------	
	
}
