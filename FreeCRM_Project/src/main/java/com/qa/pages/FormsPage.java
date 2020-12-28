package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class FormsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement formsPageText;
	
	@FindBy(xpath="//i[@class='edit icon']")
	@CacheLookup
	WebElement clickOnNewButton;

	@FindBy(xpath="//input[@name='name']")
	@CacheLookup
	WebElement enterTheName;
	
	@FindBy(xpath="//textarea[@name='intro']")
	@CacheLookup
	WebElement enterTheIntroductionText;

	@FindBy(xpath="//textarea[@name='outro']")
	@CacheLookup
	WebElement enterTheCompletionText;
	
	@FindBy(xpath="//i[@class='save icon']")
	@CacheLookup
	WebElement clickOnSaveBtn;
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement verifyTheSavedForms;
	
	public FormsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateFormsPage() {
		boolean formsText=formsPageText.isDisplayed();
		return formsText;
	}
	
	public void enteringTheFormDetails(String name,String introTxT,String completionTxT ) {
		clickOnNewButton.click();
		enterTheName.sendKeys(name);
		enterTheIntroductionText.sendKeys(introTxT);
		enterTheCompletionText.sendKeys(completionTxT);
		clickOnSaveBtn.click();
	}
	
	public String validateSavedForm() {
		String savedForm=verifyTheSavedForms.getText();
		return savedForm; 
	}
}
