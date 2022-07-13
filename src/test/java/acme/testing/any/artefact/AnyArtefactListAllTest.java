package acme.testing.any.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyArtefactListAllTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveArtefactAnonymousTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo, final String published) {

		super.clickOnMenu("Anonymous", "Artefact List");
		super.checkListingExists();

		
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, techonology);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, retailPrice);
		super.checkColumnHasValue(recordIndex, 6, moreInfo);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", techonology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("moreInfo", moreInfo);
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveArtefactInventorTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Authenticated", "Artefact List");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, techonology);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, retailPrice);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", techonology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		
		super.signOut();
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void positiveArtefactPatronTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Artefact List");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, techonology);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, retailPrice);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", techonology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		
		super.signOut();
	}
	

	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void positiveArtefactAdministratorTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Authenticated", "Artefact List");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, techonology);
		super.checkColumnHasValue(recordIndex, 4, description);
		super.checkColumnHasValue(recordIndex, 5, retailPrice);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", techonology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		
		super.signOut();
	}
	

	
	// Ancillary methods ------------------------------------------------------
}
