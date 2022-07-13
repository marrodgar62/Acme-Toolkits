package acme.testing.inventor.artefact;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorArtefactCreateTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();

		super.clickOnButton("Create");
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Create");

		super.checkListingExists();
		super.sortListing(2, "desc");

		//Revisar que la cabecera esta bien
		super.checkColumnHasValue(recordIndex, 0, type);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.checkColumnHasValue(recordIndex, 3, technology);
		super.checkColumnHasValue(recordIndex, 4, retailPrice);
		super.checkColumnHasValue(recordIndex, 5,"false");
				
		//Revisamos que el show va bien y tiene todo
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("type", type);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("moreInfo", moreInfo);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();

		super.clickOnButton("Create");
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/artefact/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativeTest2(final int recordIndex, final String type, final String name, final String code, final String technology, final String description, final String retailPrice, final String moreInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "Own artefacts");
		super.checkListingExists();

		super.clickOnButton("Create");
		
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@Test
	@Order(40)
	public void hackingTest() {
		super.checkNotLinkExists("Inventor");
		super.navigate("/inventor/artefact/create");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/artefact/create");
		super.checkPanicExists();
		super.signOut();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/artefact/create");
		super.checkPanicExists();
		super.signOut();
	}
}
