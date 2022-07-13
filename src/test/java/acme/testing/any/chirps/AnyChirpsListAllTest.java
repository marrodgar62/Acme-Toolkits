package acme.testing.any.chirps;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TemporalAwareTestHarness;

public class AnyChirpsListAllTest extends TemporalAwareTestHarness{

	
	//Test cases ---------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-chirps.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveChirpsAnoymousTest(final int recordIndex, final int deltaDays, final String title, final String author, final String body, final String email) {
		String moment;
		moment = super.computeDeltaMoment(deltaDays);
		
		super.clickOnMenu("Anonymous", "Chirp List");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-chirps.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveChirpsInventorTest(final int recordIndex, final int deltaDays, final String title, final String author, final String body, final String email) {
		String moment;
		moment = super.computeDeltaMoment(deltaDays);
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-chirps.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(30)
	public void positiveChirpsPatronTest(final int recordIndex, final int deltaDays, final String title, final String author, final String body, final String email) {
		String moment;
		moment = super.computeDeltaMoment(deltaDays);
		
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirps/list-chirps.csv", encoding="utf-8", numLinesToSkip = 1)
	@Order(40)
	public void positiveChirpsAdministratorTest(final int recordIndex, final int deltaDays, final String title, final String author, final String body, final String email) {
		String moment;
		moment = super.computeDeltaMoment(deltaDays);
		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Authenticated", "Chirps List");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, author);
		super.checkColumnHasValue(recordIndex, 3, body);
		super.checkColumnHasValue(recordIndex, 4, email);
		
		super.signOut();
		
	}
	
}
