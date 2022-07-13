package acme.testing.inventor.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorArtefactUpdateTest extends TestHarness {
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.sortListing(2, "desc");

		super.clickOnListingRecord(0);
		super.clickOnButton("Update");
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(21)
	public void positiveTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.sortListing(1, "desc");
		
		super.clickOnListingRecord(0);
		super.clickOnButton("Update");
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Update");
		
		super.checkNotErrorsExist();
		
		super.signOut();
	}
	
	
	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't provide enough support to implement this test case,
		// HINT+ so it must be performed manually:
		// HINT+ a) update a artefact if you aren't its owner;
		// HINT+ b) update a artefact with another role;
		// HINT+ c) update an published artefact;
	}
}
