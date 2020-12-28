package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class HomePage  extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	@CacheLookup
	WebElement loginAccountName ;
	
	@FindBy(xpath="//i[@class='users icon']")
	@CacheLookup
	WebElement contactsIcon;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement clickOnContactsLink;
	
	@FindBy(xpath="//i[@class='money icon']")
	@CacheLookup
	WebElement dealsIcon;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	@CacheLookup
	WebElement clickOnDealsLink;
	
	@FindBy(xpath="//i[@class='wpforms icon']")
	@CacheLookup
	WebElement formsIcon;
	
	@FindBy(xpath="//span[contains(text(),'Forms')]")
	@CacheLookup
	WebElement clickOnFormsLink;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	Actions action= new Actions(driver);
	
	public Boolean validateHomePage() {
		Boolean loggedUser=loginAccountName.isDisplayed();
		return loggedUser;
	}
	public ContactsPage clickOnContactsLink() {
		action.moveToElement(contactsIcon).moveToElement(clickOnContactsLink).click().build().perform();
		return new ContactsPage();
	}
    public DealsPage clickOnDealsLink() {
    	action.moveToElement(dealsIcon).moveToElement(clickOnDealsLink).click().build().perform();
		return new DealsPage();
	}
    public FormsPage clickOnFormsLink() {
    	action.moveToElement(formsIcon).moveToElement(clickOnFormsLink).click().build().perform();
		return new FormsPage();
    }
	
}
