package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRM");
	}

	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.Login(prop.getProperty("id"), prop.getProperty("pass"));
		log.info("Logging into the application");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser");
	}

}
