package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InventorToolkitsDeleteTest extends InventorToolkitsHarness{

	// Test cases -----------------------------
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(10)
	public void positiveDeleteToolkitInventorTest(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.checkSubmitExists("Delete");
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(20)
	public void positiveDeleteWithArtefactsToolkitInventorTest(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.clickOnButton("Update artefacts");
		super.fillInputBoxIn("quantity", "1");
		super.clickOnSubmit("Update");
		
		super.checkSubmitExists("Delete");
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
	}
	
}
