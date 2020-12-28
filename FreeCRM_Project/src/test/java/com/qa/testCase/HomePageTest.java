package com.qa.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.FormsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	FormsPage formsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		contactsPage=new ContactsPage();
		dealsPage=new DealsPage();
		formsPage=new FormsPage();
		loginPage=new LoginPage();
		homePage=loginPage.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void verifyTheHomePageTest() {
		Boolean Flag=homePage.validateHomePage();
		Assert.assertTrue(Flag);			
	}
	@Test
	public void ContactsPageTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	@Test
	public void DealsPageTest() {
		dealsPage=homePage.clickOnDealsLink();
	}
	@Test
	public void FormsPageTest() {
		formsPage=homePage.clickOnFormsLink();
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
