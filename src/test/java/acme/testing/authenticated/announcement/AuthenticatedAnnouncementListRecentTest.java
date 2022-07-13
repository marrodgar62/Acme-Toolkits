package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TemporalAwareTestHarness;

public class AuthenticatedAnnouncementListRecentTest extends TemporalAwareTestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAnnouncementInventorTest(final int recordIndex, final int creation, final String title, final String body, final String flag, final String url) {
		
		String moment;
		moment = super.computeDeltaMoment(creation);
		
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Authenticated", "Announcements list");
		super.checkListingExists();
		super.sortListing(0, "asc");


		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, flag);
		super.checkColumnHasValue(recordIndex, 4, url);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creation", moment);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("url", url);
		
		super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void positiveAnnouncementAdministratorTest(final int recordIndex, final int creation, final String title, final String body, final String flag, final String url) {
		
		String moment;
		moment = super.computeDeltaMoment(creation);
		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Authenticated", "Announcements list");
		super.checkListingExists();
		super.sortListing(0, "asc");


		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, flag);
		super.checkColumnHasValue(recordIndex, 4, url);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creation", moment);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("url", url);
		
		super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void positiveAnnouncementPatronTest(final int recordIndex, final int creation, final String title, final String body, final String flag, final String url) {
		
		String moment;
		moment = super.computeDeltaMoment(creation);
		
		
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Authenticated", "Announcements list");
		super.checkListingExists();
		super.sortListing(0, "asc");


		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, flag);
		super.checkColumnHasValue(recordIndex, 4, url);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creation", moment);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("url", url);
		
		super.signOut();

	}

	
	@ParameterizedTest
    @CsvFileSource(resources = "/authenticated/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(20)
    public void NegativeAnonymousListAnnouncementsTest(final int recordIndex, final int creation, final String title, final String body, final String flag, final String url) {

		
        super.navigate("/authenticated/announcement/list-all-announcements");

        super.checkPanicExists();
    }
	
	
	

	
}
