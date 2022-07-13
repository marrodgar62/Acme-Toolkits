package acme.testing.inventor.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class InventorArtefactDeleteTest extends TestHarness {
	@Test
	@Order(10)
	public void positiveTest() {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.sortListing(5, "asc");
		
		super.clickOnListingRecord(0);
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		super.checkListingExists();
		
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: the framework doesn't provide enough support to implement this test case,
		// HINT+ so it must be performed manually:
		// HINT+ a) delete a artefact of an inventor with another account that is not the creator;
		// HINT+ b) delete an published artefact;
	}
}
