package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[contains(text(), 'Tanish Adhikar')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	@FindBy(xpath = "//span[contains(text(), 'Contacts12345')]")
	WebElement fakecontactsLink;

	@FindBy(xpath = "//button[@class='ui linkedin button' and text()='New']")
	WebElement newContactsLink;

	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	WebElement dealLink;

	@FindBy(xpath = "//span[contains(text(), 'Tasks')]")
	WebElement taskLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public ContactsPage clickOnContacts() {
		contactsLink.click();
		return new ContactsPage();
	}

	public ContactsPage fakeclickOnContacts() {
		fakecontactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsPage() {
		dealLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskPage() {
		taskLink.click();
		return new TaskPage();

	}

	public Boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();

	}

	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();

	}

}
