package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.testBase.TestBase;

public class TestUtils extends TestBase {

	public static int PAGELOAD_TIMEOUTS=30;
	public static int IMPLICIT_WAIT_TIMEOUTS=40;
	static Xls_Reader reader;
	
	//Taking ScreenShot
		public static void takeScreenshotAtEndOfTest() throws IOException {
			
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDir=System.getProperty("user.dir");
			
			FileUtils.copyFile(file,new File(currentDir+"\\FailedTestScreenShot\\"+System.currentTimeMillis()+".jpg"));
		}
	
	//Login Page Data 
	public static ArrayList<Object[]> getLoginDataFromExcel() {
		ArrayList<Object[]> myData= new ArrayList<Object[]>();
		reader=new Xls_Reader("C:\\Framework_Projects\\FreeCRM_Project\\src\\main\\java\\com\\qa\\testData\\FreeCRMTestData.xlsx");
		
		for(int rowNum=2;rowNum<=reader.getRowCount("LoginData");rowNum++) {
			String username=reader.getCellData("LoginData", "username", rowNum);
			String password=reader.getCellData("LoginData", "password", rowNum);
			
			Object ob[]= {username,password};
			myData.add(ob);
		}
		return myData;
	}
	
	//Contacts Page Data
	public static ArrayList<Object[]> getContactsRegDataFromExcel() {
		ArrayList<Object[]> myData1= new ArrayList<Object[]>();
		reader=new Xls_Reader("C:\\Framework_Projects\\FreeCRM_Project\\src\\main\\java\\com\\qa\\testData\\FreeCRMTestData.xlsx");
		
		for(int rowNum=2;rowNum<=reader.getRowCount("ContactsRegData");rowNum++) {
			String firstname =reader.getCellData("ContactsRegData", "FirstName", rowNum);
			String lastname =reader.getCellData("ContactsRegData", "LastName", rowNum);
			String email =reader.getCellData("ContactsRegData", "Email", rowNum);
			String streetaddress =reader.getCellData("ContactsRegData", "StreetAddress", rowNum);
			String city =reader.getCellData("ContactsRegData", "City", rowNum);
			String state =reader.getCellData("ContactsRegData", "State", rowNum);
			String zipcode =reader.getCellData("ContactsRegData", "Zipcode", rowNum);
			String country =reader.getCellData("ContactsRegData", "Country", rowNum);
			
			Object ob1[]= {firstname,lastname,email,streetaddress,city,state,zipcode,country};
			myData1.add(ob1);
		}
		return myData1;
	}
		//Deals Page Data
		public static ArrayList<Object[]> getDealsDataFromExcel() {
			ArrayList<Object[]> myData2= new ArrayList<Object[]>();
			reader=new Xls_Reader("C:\\Framework_Projects\\FreeCRM_Project\\src\\main\\java\\com\\qa\\testData\\FreeCRMTestData.xlsx");
			
		for(int rowNum=2;rowNum<=reader.getRowCount("DealsData");rowNum++) {
			String title=reader.getCellData("DealsData", "Title", rowNum);
			String description=reader.getCellData("DealsData", "Description", rowNum);
			String amount=reader.getCellData("DealsData", "Amount", rowNum);
			String commission=reader.getCellData("DealsData", "Commission", rowNum);
			Object ob2[]= {title,description,amount,commission};
			myData2.add(ob2);
		}
		return myData2;
	}
		
		//Forms Page Data
		public static ArrayList<Object[]> getFormsDataFromExcel() {
			ArrayList<Object[]> myData3= new ArrayList<Object[]>();
			reader=new Xls_Reader("C:\\Framework_Projects\\FreeCRM_Project\\src\\main\\java\\com\\qa\\testData\\FreeCRMTestData.xlsx");
			
		for(int rowNum=2;rowNum<=reader.getRowCount("FormsData");rowNum++) {
			String name=reader.getCellData("FormsData", "Name", rowNum);
			String introTxt=reader.getCellData("FormsData", "Introduction Text", rowNum);
			String completionTxt=reader.getCellData("FormsData", "Completion Text", rowNum);
			Object ob3[]= {name,introTxt,completionTxt};
			myData3.add(ob3);
		}
		return myData3;
		
	}
}
