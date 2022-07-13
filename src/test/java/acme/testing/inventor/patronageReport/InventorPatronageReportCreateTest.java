package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/create-positive-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String memorandum,final String link) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My Patronages");
		super.clickOnListingRecord(0);
		
		super.checkButtonExists("Create Patronage Report");
		
		super.clickOnButton("Create Patronage Report");
		
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create");
		
		
		//Checking good creation
		super.clickOnButton("Patronage Reports");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 1, memorandum);
		super.checkColumnHasValue(recordIndex, 2, link);
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		
		super.signOut();
		
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage-report/create-negative-patronage-report.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex,final String memorandum,final String link) {
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My Patronages");
		super.clickOnListingRecord(0);
		
		super.checkButtonExists("Create Patronage Report");
		
		super.clickOnButton("Create Patronage Report");
		
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create");
		
		super.checkErrorsExist();
		
		super.signOut();
		
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		/*
		 * super.checkNotLinkExists("Account");
		 * super.navigate("http://localhost:8080/acme-toolkits-0.1/inventor/patronage-report/create?id=33");
		 * super.checkPanicExists();
		 * 
		 * 
		 * super.signIn("inventor2", "inventor2");
		 * super.navigate("http://localhost:8080/acme-toolkits-0.1/inventor/patronage-report/create?id=33");
		 * super.checkPanicExists();
		 * super.signOut();
		 * 
		 * super.signIn("patron1", "patron1");
		 * super.navigate("http://localhost:8080/acme-toolkits-0.1/inventor/patronage-report/create?id=33");
		 * super.checkPanicExists();
		 * super.signOut();
		 * 
		 * super.signIn("administrator", "administrator");
		 * super.navigate("http://localhost:8080/acme-toolkits-0.1/inventor/patronage-report/create?id=33");
		 * super.checkPanicExists();
		 * super.signOut();
		 */
	
	}
	
}
