package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@placeholder='E-mail address']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	@CacheLookup
	WebElement forgetPasswordButton;
	
	@FindBy(xpath="//a[contains(text(),'Classic CRM')]")
	@CacheLookup
	WebElement LoginWithClassicCRMButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement NewAccountRegistrationButton;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String validatLoginPage() {
		String actualLPTitle=driver.getTitle();
		return actualLPTitle;
	}
	public HomePage enterLoginDetails(String un,String pwd) {
		userName.clear();
		userName.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	public ForgetPasswordPage clickForgetPasswordButton() {
		forgetPasswordButton.click();
		return new ForgetPasswordPage();
	}
	public ClassicCRMPage clickClassicCRMButton() {
		LoginWithClassicCRMButton.click();
		return new ClassicCRMPage();
	}
}
