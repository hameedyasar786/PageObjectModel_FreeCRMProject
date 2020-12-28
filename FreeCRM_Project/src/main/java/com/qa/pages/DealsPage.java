package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement dealsPageText;
	
	@FindBy(xpath="//i[@class='edit icon']")
	@CacheLookup
	WebElement clickOnNewButton;
	
	@FindBy(xpath="//input[@name='title']")
	@CacheLookup
	WebElement title;
	
	@FindBy(xpath="//textarea[@name='description']")
	@CacheLookup
	WebElement enterTheDescription ;
	
	@FindBy(xpath="//input[@name='amount']")
	@CacheLookup
	WebElement enterTheAmount;
	
	@FindBy(xpath="//input[@name='commission']")
	@CacheLookup
	WebElement enterTheCommission ;
		
	@FindBy(xpath="//i[@class='save icon']")
	@CacheLookup
	WebElement clickOnSaveBtn;

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement verifyTheSavedDeals;
	
	public DealsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public boolean validateDealPage() {
		boolean dealsText=dealsPageText.isDisplayed();
		return dealsText;
	}
	
	public void enteringTheDealsDetails(String ttle,String description,String amount,String commission) {
		clickOnNewButton.click();
		title.sendKeys(ttle);
		enterTheDescription.sendKeys(description);
		enterTheAmount.sendKeys(amount);
		enterTheCommission.sendKeys(commission);
		clickOnSaveBtn.click();		
	}
		
	public String validateSavedDeal() {
		String savedDeal=verifyTheSavedDeals.getText();
		return savedDeal; 
	}
	
}
