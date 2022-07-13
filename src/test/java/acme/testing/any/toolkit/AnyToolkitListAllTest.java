package acme.testing.any.toolkit;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitListAllTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveListToolkitPatronTest(final int recordIndex,final String code, final String title, final String description, final String assemblyNotes, final String link) {
	
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Toolkit list");
		
		super.checkListingExists();
	
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, assemblyNotes);
		super.checkColumnHasValue(recordIndex, 4, link);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveListToolkitAnonymousTest(final int recordIndex,final String code, final String title, final String description, final String assemblyNotes, final String link) {
	
		
		super.clickOnMenu("Anonymous", "Toolkit list");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, assemblyNotes);
		super.checkColumnHasValue(recordIndex, 4, link);
	
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-toolkit-filter.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveListToolkitByQueryPatronTest(final int recordIndex, final int recordIndex2, final String queryArtefactName, final String artefactName) {
	
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Toolkit list");
		super.checkListingExists();
		
		super.fillInputBoxIn("artefactName", queryArtefactName);
		super.clickOnSubmit("Filter");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Artefacts");
		
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex2, 1, artefactName);
		
	}
	
	@Test
	@Order(21)
	public void positiveListToolkitByQueryAnonymousTestBlank() {
	
		
		super.clickOnMenu("Anonymous", "Toolkit list");
		super.checkListingExists();
		
		super.fillInputBoxIn("artefactName", "");
		super.clickOnSubmit("Filter");
		super.checkListingExists();
		super.checkNotListingEmpty();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-toolkit-filter-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativeListToolkitByQueryPatronTest(final String queryArtefactName) {

		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Toolkit list");
		super.checkListingExists();
		
		super.fillInputBoxIn("artefactName", queryArtefactName);
		super.clickOnSubmit("Filter");
		super.checkListingEmpty();
	}
	


	
	

	
	// Ancillary methods ------------------------------------------------------
}
