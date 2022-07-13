package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InventorToolkitsPublishTest extends InventorToolkitsHarness{

	// Test cases -----------------------------
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(10)
	public void createToolkit(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkNotErrorsExist();
	}
	
	
	@Test
	@Order(20)
	public void negativePublishWithNoArtefactsToolkitInventorTest() {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My toolkits");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		
		super.checkSubmitExists("Publish");
		super.clickOnSubmit("Publish");
		
		
	}
	

	
	@Test
	@Order(30)
	public void positivePublishToolkitInventorTest() {
		final String componentId = super.getIdArtefactComponentOrTool(true);
		final String toolId = super.getIdArtefactComponentOrTool(false);
		super.signIn("inventor1", "inventor1");
		super.updateArtefactFirstToolkit("1", toolId);
		super.updateArtefactFirstToolkit("1", componentId);
		super.clickOnMenu("Inventor", "My toolkits");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		super.checkNotSubmitExists("Publish");
		
	}
	

}
