package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/list-user-account.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void anonymousPositiveUserAccountTest(final int recordIndex, final String rol, 
		final String username, final String name, final String surname, final String email) {
		

		super.clickOnMenu("Anonymous", "User Accounts List");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, rol);
		super.checkColumnHasValue(recordIndex, 1, username);
		

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("username", username);
		super.checkInputBoxHasValue("identity.name", name);
		super.checkInputBoxHasValue("identity.surname", surname);
		super.checkInputBoxHasValue("identity.email", email);

	}

}
