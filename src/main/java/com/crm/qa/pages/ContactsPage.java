package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	// td[text()='Text 2
	// Adhikari']//parent::tr[@class='']//preceding-sibling::input[@name='id']
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='middle_name']")
	WebElement middleName;
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lastName;
	@FindBy(xpath = "//div[@name='company']")
	WebElement companyName;
	@FindBy(xpath = "//button[@class='ui linkedin button' and text()='Save']")
	WebElement saveButton;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean VerifyContactsLabel() {
		return contactsLabel.isDisplayed();

	}

	public void slectsContactsByName() {

		// USAGE OF EXPLICIT WAIT BUT NOT WORKING
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 5);
		 * 
		 * WebElement usernameClick =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By
		 * .xpath("//td[text()='Text 2 Adhikari']//parent::tr[@class='']//preceding-sibling::input[@name='id']"
		 * ))); usernameClick.click();
		 * 
		 * /* //USAGE OF REGULAR WAY AND NOT WORKING driver.findElement(By.xpath(
		 * "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]/div/input"
		 * )).click(); xpath cusomized =//td[text()='Text 2
		 * Adhikari']//parent::tr[@class='']//preceding-sibling::input[@name='id']
		 */

		// USAGE OF MOUSEMOVEMENT

		Actions act = new Actions(driver);
		WebElement nameClick = driver
				.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]"));
		act.moveToElement(nameClick).click();

	}

	public void createNewContacts(String frstName, String midname, String lastnme, String company) {

		firstName.sendKeys(frstName);
		middleName.sendKeys(midname);
		lastName.sendKeys(lastnme);
		Actions action = new Actions(driver);
		action.moveToElement(companyName).sendKeys(company);

		// companyName.sendKeys(company);
		saveButton.click();
	}
}
