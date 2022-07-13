package acme.testing.inventor.toolkits;




import acme.testing.TestHarness;

public class InventorToolkitsHarness extends TestHarness{

	// Test cases -----------------------------
	
	
	public void createToolkit(final String code, final String title, final String description, final String AssemblyNotes, final String link) {
		super.clickOnMenu("Inventor", "My toolkits");
		super.clickOnButton("Create toolkit");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("assemblyNotes", AssemblyNotes);
		super.fillInputBoxIn("link", link);
		super.clickOnSubmit("Create");
	}

	public void updateFirstToolkit(final String input, final String value) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Update");
		super.fillInputBoxIn(input, value);
		super.clickOnSubmit("Update");

	}
	
	public void updateArtefactFirstToolkit(final String quantityValue, final String artefactValue) {
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkNotErrorsExist();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Update artefacts");
		super.fillInputBoxIn("quantity", quantityValue);
		super.fillInputBoxIn("artefactId", artefactValue);
		super.clickOnSubmit("Update");
	}
	
	public String getIdArtefactComponentOrTool(final Boolean component) {
		super.clickOnMenu("Anonymous", "Toolkit list");
		super.checkListingExists();
		if(component) {
			super.fillInputBoxIn("artefactName", "name03");
		}else {
			super.fillInputBoxIn("artefactName", "name04");
		}
		super.clickOnSubmit("Filter");
		super.sortListing(1, "asc");
		super.clickOnListingRecord(0);
		super.clickOnButton("Artefacts");
		super.sortListing(0, "asc");
		super.clickOnListingRecord(0);
		return super.getCurrentQuery().replace("?id=", "");
	}
	
	
}
