package acme.testing.inventor.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorArtefactPublishTest extends TestHarness {
	
	@Test
	@Order(10)
	public void positiveTest() {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.clickOnListingRecord(0);
		super.sortListing(5, "desc");
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		super.checkListingExists();
		
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't provide enough support to implement this test case,
		// HINT+ so it must be performed manually:
		// HINT+ a) publish an artefact with a role other than "Inventor";
		// HINT+ b) publish an artefact if it is not its owner;
		// HINT+ c) publish an published artefact 
	}

}
