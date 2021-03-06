package com.qa.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;

import com.qa.pages.FormsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;
import com.qa.utils.TestUtils;

public class FormsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	FormsPage formsPage;
	
	public FormsPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		formsPage=new FormsPage();
		homePage=loginPage.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		formsPage=homePage.clickOnFormsLink();
	}
	
	@Test
	public void verifyTheFormsPageTest() {
		boolean Flag=formsPage.validateFormsPage();
		Assert.assertTrue(Flag,"Forms label is missing on the page");
	}
	
	@DataProvider
	public Iterator<Object[]> getFormsTestData() {
		ArrayList<Object[]> FormsPageTestData=TestUtils.getFormsDataFromExcel();
		return FormsPageTestData.iterator();
	}
	@Test(dataProvider="getFormsTestData")
	public void newFormsDetailsTest(String Name,String IntroTxT,String CompletionTxT ) {
		formsPage.enteringTheFormDetails(Name, IntroTxT, CompletionTxT);
	}
	@Test
	public void verifyTheSavedDetailsTest() {
		formsPage.validateSavedForm();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
