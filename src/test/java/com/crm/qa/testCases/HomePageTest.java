package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("id"), prop.getProperty("pass"));
		contactPage = new ContactsPage();
	}

	@Test(priority = 1)
	public void verifyHomePageTest() {

		String homePageTitle = homePage.verifyHomePageTitle();

		Assert.assertEquals(homePageTitle, "CRM", "Home Page Title not matched");
	}

	@Test(priority = 2)
	public void verifyUsernameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName(), "User Name not matched");
	}

	@Test(priority = 3)
	public void verifyContactsPageTest() {
		contactPage = homePage.clickOnContacts();
	}

	@Test(priority = 4)
	public void deliberatelyFailTest() {
		log.warn("This is just a fake warning");
		log.fatal("This is just a fake fatal warning....deliberately given");
		contactPage = homePage.fakeclickOnContacts();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
