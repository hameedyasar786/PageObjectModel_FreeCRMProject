package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.testBase.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement contactsPageText;
	
	@FindBy(xpath="//i[@class='edit icon']")
	@CacheLookup
	WebElement clickOnNewButton;
	
	@FindBy(xpath="//input[@name='first_name']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Street Address']")
	@CacheLookup
	WebElement streetAddress;
	
	@FindBy(xpath="//input[@placeholder='City']")
	@CacheLookup
	WebElement city;
	
	@FindBy(xpath="//input[@placeholder='State / County']")
	@CacheLookup
	WebElement state;
	
	@FindBy(xpath="//input[@placeholder='Zip Code']")
	@CacheLookup
	WebElement zipcode;
	
	@FindBy(xpath="//div[@name='country']")
	@CacheLookup
	WebElement clickDropDownButton;
	
	@FindBy(xpath="//div[@role='option']")
	@CacheLookup
	List <WebElement> listOfCountries;
	
	@FindBy(xpath="//i[@class='save icon']")
	@CacheLookup
	WebElement clickOnSaveBtn;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement verifySavedContact;
	
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateContactPage() {
		boolean contactsText=contactsPageText.isDisplayed();
		return contactsText;
	}
	
	public void enteringTheNewContactDetails(String FN,String LN,String Email,String StreetAddress,String City,String State,String Zipcode,String Country) {
		clickOnNewButton.click();
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		email.sendKeys(Email);
		streetAddress.sendKeys(StreetAddress);
		city.sendKeys(City);
		state.sendKeys(State);
		zipcode.sendKeys(Zipcode);
		clickDropDownButton.click();
		for(int i=0;i<=listOfCountries.size();i++) {
			if(listOfCountries.get(i).getText().contains(Country)) {
				listOfCountries.get(i).click();
				break;
			}
		}
		clickOnSaveBtn.click();		
	}
	
	public String validateSavedcontact() {
		String savedContactName=verifySavedContact.getText();
		return savedContactName; 
	}
}