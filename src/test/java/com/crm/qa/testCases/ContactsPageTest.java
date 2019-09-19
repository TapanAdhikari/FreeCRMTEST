package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	String sheetName = "contacts";

	public ContactsPageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("id"), prop.getProperty("pass"));

		contactPage = homePage.clickOnContacts();
		// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactPage.VerifyContactsLabel(), "Contacts Label is missing");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactPage.slectsContactsByName();
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);

		return data;
	}

	@Test(priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {

		homePage.clickOnNewContactsLink();
		// contactPage.createNewContacts("Khokan", "Chandra", "Adhikari", "BRACC");

		contactPage.createNewContacts(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
