package acme.testing.any.chirps;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpsCreateTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAnonymousChirpsCreateTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		super.clickOnMenu("Anonymous", "Chirp List");
		super.checkListingExists();

		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Anonymous", "Chirp List");
		super.sortListing(0, "desc");		
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positivePatronChirpsCreateTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();

		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Authenticated", "Chirps List");
		super.sortListing(0, "desc");
		
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(30)
	public void positiveInventorChirpsCreateTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();

		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Authenticated", "Chirps List");
		super.sortListing(0, "desc");
		
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(40)
	public void positiveAdministratorChirpsCreateTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();

		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Authenticated", "Chirps List");
		super.sortListing(0, "desc");
		
		
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
	}
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(50)
	public void negativeChirpsCreateWithoutConfirmationTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		super.clickOnMenu("Anonymous", "Chirp List");
		super.checkListingExists();

		super.clickOnButton("Create");
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		
		
		super.clickOnSubmit("Create");
	
		super.checkErrorsExist();
		
		
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-create-negative.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(60)
	public void negativeChirpsCreateWithoutInformationTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email) {
		
		super.clickOnMenu("Anonymous", "Chirp List");
		super.checkListingExists();
		
		super.clickOnButton("Create");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", "true");
		
		super.clickOnSubmit("Create");
		super.checkErrorsExist();
		
		
	}
	
}
