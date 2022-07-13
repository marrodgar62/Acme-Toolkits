package acme.testing.inventor.toolkits;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InventorToolkitsUpdateTest extends InventorToolkitsHarness{

	// Test cases ----------------------------- 
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits.csv", encoding = "utf-8", numLinesToSkip = 2)
	@Order(10)
	public void createToolkit(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.signIn("inventor1", "inventor1");
		super.createToolkit(code, title, description, assemblyNotes, link);
		super.checkNotErrorsExist();
	}

	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeToolkitInventorTestCode(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("code", code);
		super.checkErrorsExist("code");
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(30)
	public void negativeToolkitInventorTestTitle(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("title", title);
		super.checkErrorsExist("title");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(40)
	public void negativeToolkitInventorTestDescription(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("description", description);
		super.checkErrorsExist("description");
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(50)
	public void negativeToolkitInventorTestAssemblyNotes(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("assemblyNotes", assemblyNotes);
		super.checkErrorsExist("assemblyNotes");

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/create-toolkits-negative.csv", encoding = "utf-8", numLinesToSkip = 3)
	@Order(60)
	public void negativeToolkitInventorTestLink(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("link", link);
		super.checkErrorsExist("link");
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/update-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(70)
	public void positiveToolkitInventorTestTitle(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("title", title);
		super.checkInputBoxHasValue("title", title);

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/update-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(80)
	public void positiveToolkitInventorTestDescription(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("description", description);
		super.checkInputBoxHasValue("description", description);
	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/update-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(90)
	public void positiveToolkitInventorTestAssemblyNotes(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);

	}
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/Toolkits/update-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(100)
	public void positiveToolkitInventorTestLink(final int recordIndex, final String code, final String title, final String description, final String assemblyNotes, final String link) {
		super.updateFirstToolkit("link", link);
		super.checkInputBoxHasValue("link", link);
		
	}


	
}
