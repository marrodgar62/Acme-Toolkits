package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InventorToolkitsCreateTest extends InventorToolkitsHarness{

	// Test cases -----------------------------
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolkitInventorTest(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.clickOnListingRecord(recordIndex);

		super.checkButtonExists("Artefacts");
		super.checkButtonExists("Update artefacts");
		super.checkButtonExists("Update");
		super.checkSubmitExists("Delete");
		super.checkSubmitExists("Publish");
		
		super.clickOnButton("Artefacts");
		super.checkListingEmpty();
		
		super.signOut();
	}
	
	
	@Test
	@Order(12)
	public void negativeToolkitPatronTest() {
		super.signIn("patron1", "patron1");
		super.navigate("/inventor/toolkit/create");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeToolkitInventorTestCode(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkErrorsExist("code");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(30)
	public void negativeToolkitInventorTestTitle(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);

		super.checkErrorsExist("title");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(40)
	public void negativeToolkitInventorTestDescription(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkErrorsExist("description");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(50)
	public void negativeToolkitInventorTestAssemblyNotes(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkErrorsExist("assemblyNotes");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 3)
	@Order(60)
	public void negativeToolkitInventorTestLink(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkErrorsExist("link");
		
		super.signOut();
	}


	
	
}
