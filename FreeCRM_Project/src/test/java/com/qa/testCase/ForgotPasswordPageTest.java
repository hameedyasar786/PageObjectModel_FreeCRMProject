package com.qa.testCase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.ForgetPasswordPage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;


public class ForgotPasswordPageTest extends TestBase{
	LoginPage loginPage;
	ForgetPasswordPage forgetPwdPage;
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		forgetPwdPage=new ForgetPasswordPage();
	}
	
	@Test
	public void ForgotPasswordLinkeTest() {
		forgetPwdPage.clickOnForgotPasswordLink();
	}
	@Test
	public void enterTheForgotPasswordEmailTest() {
		forgetPwdPage.enterRegisteredEmail();
	}
	@Test
	public void confirmationMsgTest() {
		String Msg=forgetPwdPage.confirmationMessage();
		System.out.println("The confirmation Message: " + Msg);
	}
	@Test
	public void GotAnAccountLogInHerePageTest() {
		loginPage=forgetPwdPage.clickOnGotAnAccountLogInHereLink();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
