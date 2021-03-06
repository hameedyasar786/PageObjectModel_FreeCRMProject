package com.qa.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;

import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;
import com.qa.utils.TestUtils;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	public DealsPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		dealsPage=new DealsPage();
		homePage=loginPage.enterLoginDetails(prop.getProperty("username"),prop.getProperty("password"));
		dealsPage=homePage.clickOnDealsLink();
	}
	@Test
	public void verifyTheDealsPageTest() {
		boolean Flag=dealsPage.validateDealPage();
		Assert.assertTrue(Flag,"Deals label is missing on the page");
	}
	@DataProvider
	public Iterator<Object[]> getDealsTestData() {
		ArrayList<Object[]> dealsTestData=TestUtils.getDealsDataFromExcel();
		return dealsTestData.iterator();
		
	}
	@Test(dataProvider="getDealsTestData")
	public void newDealsDetailsTest(String Title,String Description,String Amount,String Commission) {
		dealsPage.enteringTheDealsDetails(Title, Description, Amount, Commission);
	}
	@Test
	public void verifyTheSavedDetailsTest() {
		dealsPage.validateSavedDeal();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
