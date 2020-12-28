package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class ForgetPasswordPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	@CacheLookup
	WebElement forgotPwdLink;
	
	@FindBy(xpath="//input[@name='email']")
	@CacheLookup
	WebElement emailAddress;
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement resetPasswordBtn;
	
	@FindBy(xpath="//div[@class='field']")
	@CacheLookup
	WebElement forgotPwdConfirmationMsg;
	
	@FindBy(xpath="//a[contains(text(),'Got an account? Log in here')]")
	@CacheLookup
	WebElement  accountLoginHere;
		
	public ForgetPasswordPage() {
		PageFactory.initElements(driver,this);
	}
	public void clickOnForgotPasswordLink() {
		forgotPwdLink.click();
	}
	public void enterRegisteredEmail() {
		emailAddress.sendKeys(prop.getProperty("username"));
		resetPasswordBtn.click();
	}
	public String confirmationMessage() {
		String confirmationMessage=forgotPwdConfirmationMsg.getText();
		return confirmationMessage;
	}
	public LoginPage clickOnGotAnAccountLogInHereLink(){
		return new LoginPage();
		
	}
	

}
