package com.qa.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.qa.pages.ClassicCRMPage;
import com.qa.pages.ForgetPasswordPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testBase.TestBase;
import com.qa.utils.TestUtils;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ForgetPasswordPage forgetPwdPage;
	ClassicCRMPage classicCrmPage;	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		testUtils=new TestUtils();
		forgetPwdPage=new ForgetPasswordPage();
		classicCrmPage=new ClassicCRMPage();
	}
	
	@Test(priority=1)
	public void verifyTheLoginPageTest() {
		String actualTitle=loginPage.validatLoginPage();
		AssertJUnit.assertEquals(actualTitle,"Cogmento CRM");
	}
	
	@DataProvider
	public Iterator<Object[]> getLoginTestData() {
		ArrayList<Object[]> LoginTestData=TestUtils.getLoginDataFromExcel();
		return LoginTestData.iterator();
		
	}
	@Test(priority=2,dataProvider="getLoginTestData")
	public void LoginTest(String username,String password) {
		
		homePage=loginPage.enterLoginDetails(username, password);
	}
	@Test(priority=3)
	public void ClickOnForgetPasswordLinkTest() {
		forgetPwdPage=loginPage.clickForgetPasswordButton();
	}
	@Test(priority=4)
	public void ClickOnClassicCRMPageTest() {
		classicCrmPage=loginPage.clickClassicCRMButton();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
