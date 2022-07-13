package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitsListTest extends TestHarness{

	// Test cases -----------------------------
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/list-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolkitInventorTest(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link,final String published) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, assemblyNotes);
		super.checkColumnHasValue(recordIndex, 4, link);
		super.checkColumnHasValue(recordIndex, 5, published);
		
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("published", published);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/artefacts-list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveToolInventorTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();
		super.sortListing(0, "desc");		
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Artefacts");

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
		super.checkInputBoxHasValue("moreInfo",moreInfo);
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/artefacts-list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void NegativeToolInventorTest(final int recordIndex) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Artefacts");
		final String query = super.getCurrentQuery();

		super.signOut();

		
		super.signIn("inventor2", "inventor2");

		final String queryNueva = query.substring(1);
		super.navigate("/inventor/artefact/list-artefact-toolkit",queryNueva);
		super.checkPanicExists();

		super.signOut();
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/list-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void NegativeToolkitInventorTest(final int recordIndex) {
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "My toolkits");
		super.checkListingExists();
		super.clickOnListingRecord(recordIndex);
		final String query = super.getCurrentQuery();

		super.signOut();

		
		super.signIn("inventor2", "inventor2");

		final String queryNueva = query.substring(1);
		super.navigate("/inventor/toolkit/show",queryNueva);
		super.checkPanicExists();

		super.signOut();
		
	}
	

	
}
