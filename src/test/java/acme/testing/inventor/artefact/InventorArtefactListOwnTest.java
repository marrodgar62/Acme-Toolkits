package acme.testing.inventor.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorArtefactListOwnTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveArtefactInventorTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {

		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.sortListing(1, "asc");
		


		//Revisar que la cabecera esta bien
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, techonology);
		super.checkColumnHasValue(recordIndex, 4, retailPrice);
		
		//Revisamos que el show va bien y tiene todo
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", techonology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("moreInfo", moreInfo);

	}
	
	
	@ParameterizedTest
    @CsvFileSource(resources = "/inventor/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(20)
    public void NegativeAnonymousListOwnArtefactsTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {

        super.navigate("/inventor/artefact/list-own");

        super.checkPanicExists();
    }
	
	@ParameterizedTest
    @CsvFileSource(resources = "/inventor/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(20)
    public void NegativePatronListOwnArtefactsTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {

		super.signIn("patron1", "patron1");
        super.navigate("/inventor/artefact/list-own");

        super.checkPanicExists();
    }
	
	
	@ParameterizedTest
    @CsvFileSource(resources = "/inventor/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(20)
    public void NegativeAdministratorListOwnArtefactsTest(final int recordIndex, final String status, final String code, final String legalStuff, final String budget, final String initPeriod, final String finalPeriod, final String link, final String username, final String company) {

		super.signIn("administrator", "administrator");
        super.navigate("/inventor/artefact/list-own");

        super.checkPanicExists();
    }
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/list-artefact.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeArtefactInventorTest(final int recordIndex, final String type, final String name, final String code, final String techonology, final String description, final String retailPrice, final String moreInfo) {

		super.signIn("inventor4", "inventor4");
		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkListingEmpty();
		super.signOut();
		
		
	}

}
