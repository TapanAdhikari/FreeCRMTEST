package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
	WebElement username;

	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")
	WebElement password;

	@FindBy(xpath = "//*[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//a[contains(text(), 'Classic CRM')]")
	WebElement ClassicCRM;
	@FindBy(xpath = "//div[@class='bot_column']")
	WebElement SauceDemoLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();

	}
}
