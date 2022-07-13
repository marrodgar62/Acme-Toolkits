package acme.testing.administrator.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorCreateAnnouncementTest extends TestHarness{

	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAnnouncementAdministratorCreateTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Create Announcement");

		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", flag);
		super.fillInputBoxIn("url", url);
		
		super.fillInputBoxIn("confirmation", "true");

		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Authenticated", "Announcements list");
		super.sortListing(0, "desc");		


		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, body);
		super.checkColumnHasValue(recordIndex, 3, flag);
		super.checkColumnHasValue(recordIndex, 4, url);
		
		super.signOut();



		
	}
	

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/list-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeAnnouncementCreateWhithoutConfirmationTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {

		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Create Announcement");

		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", flag);
		super.fillInputBoxIn("url", url);
		

		super.clickOnSubmit("Create");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/negative-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativeAnnouncementCreateWhithoutInformationTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {

		
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Create Announcement");

		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("flag", flag);
		super.fillInputBoxIn("url", url);
		
		super.fillInputBoxIn("confirmation", "true");


		super.clickOnSubmit("Create");
		super.checkErrorsExist();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/negative-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void negativeAnnouncementCreatePatronTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {
		
		
		
		super.signIn("patron1", "patron1");
		
		super.navigate("/administrator/announcement/create");
		
        super.checkPanicExists();


		
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/negative-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void negativeAnnouncementCreateInventorTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {
		
		
		
		super.signIn("inventor1", "inventor1");
		
		super.navigate("/administrator/announcement/create");
		
        super.checkPanicExists();


		
		
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/negative-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(60)
	public void negativeAnnouncementCreateAnonymousTest(final int recordIndex, final String creation, final String title, final String body, final String flag, final String url) {
		
		
		
		
		super.navigate("/administrator/announcement/create");
		
        super.checkPanicExists();


		
		
	}
}
