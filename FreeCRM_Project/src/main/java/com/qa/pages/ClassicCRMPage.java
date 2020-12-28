package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class ClassicCRMPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	@CacheLookup
	WebElement clickOnClassicCRMLink;
	
	@FindBy(xpath="//img[@alt='CRM PRO']")
	@CacheLookup
	WebElement CRMLogo;
	
	@FindBy(xpath="//input[@placeholder='Login']")
	@CacheLookup
	WebElement loginID;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement loginBtn;
	


	public ClassicCRMPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnClassicCRMLink() {
		clickOnClassicCRMLink.click();
	}
	
	public boolean validateClassicCRMPageByCRMLogo() {
		boolean logo=CRMLogo.isDisplayed();
		return logo;
	}
	
	public void EnteringLoginDetails() {
		loginID.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
	}

	public String validateClassicCRMPageLoggedInPageTitle() {
		String actualClassicCRMPageTitle=driver.getTitle();
		return actualClassicCRMPageTitle;
	}
}
