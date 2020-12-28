package com.qa.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.ClassicCRMPage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;


public class ClassicCRMPageTest extends TestBase{
	LoginPage loginPage;
	ClassicCRMPage classicCRMPage;
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		classicCRMPage=new ClassicCRMPage();
	}
	@Test
	public void clickClassicCRMButtonTest() {
		classicCRMPage.clickOnClassicCRMLink();
	}
	@Test
	public void ClassicCRMPageByLogoTest() {
		boolean Flag=classicCRMPage.validateClassicCRMPageByCRMLogo();
		Assert.assertTrue(Flag,"Classic CRM Logo Not Present In The Page");
	}
	@Test
	public void classicCRMLoginTest() {
		classicCRMPage.EnteringLoginDetails();
	}
	@Test
	public void LoggedInTitleTest() {
		String actualLoggedInPageTitle=classicCRMPage.validateClassicCRMPageLoggedInPageTitle();
		Assert.assertEquals(actualLoggedInPageTitle,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
