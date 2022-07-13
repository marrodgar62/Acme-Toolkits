package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InventorToolkitsUpdateArtefactsTest extends InventorToolkitsHarness{

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
	public void positiveUpdateArtefactToolkitInventorTest() {
		final String componentId  = super.getIdArtefactComponentOrTool(true);
		final String toolId  = super.getIdArtefactComponentOrTool(false);
		super.signIn("inventor1", "inventor1");
		super.updateArtefactFirstToolkit("4",componentId);
		super.updateArtefactFirstToolkit("1",toolId);
		super.clickOnButton("Artefacts");
		super.sortListing(1,"asc");
		super.checkColumnHasValue(0, 7, "4");
		super.checkColumnHasValue(1, 7, "1");
	}
	
	@Test
	@Order(30)
	public void positiveDeleteArtefactToolkitInventorTest() {
		final String componentId  = super.getIdArtefactComponentOrTool(true);
		final String toolId  = super.getIdArtefactComponentOrTool(false);
		super.signIn("inventor1", "inventor1");
		super.updateArtefactFirstToolkit("0",componentId);
		super.updateArtefactFirstToolkit("0",toolId);
		super.clickOnButton("Artefacts");
		super.checkListingEmpty();
	}
	@Test
	@Order(40)
	public void negativeUpdateToolToolkitInventorTest() {
		final String toolId  = super.getIdArtefactComponentOrTool(false);
		super.signIn("inventor1", "inventor1");
		super.updateArtefactFirstToolkit("-5",toolId);
		super.checkSubmitExists("Update");
	}
}
