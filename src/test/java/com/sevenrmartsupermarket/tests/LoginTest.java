package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader=new ExcelReader();
	
	@Test
	public void verifyLoginFunctionality()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="Admin";
		Assert.assertEquals(actualProfileName,expectedProfileName,"Profile Name mismatch");
		
	}
	@Test
	public void verifyInvalidLoginErrorMessage()
	{
		loginpage=new LoginPage(driver);
		loginpage.login("Luke","abcd");

	}
	@Test
	public void verifyStaffLogin()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);	
		excelreader.setExcelFile("LoginData","Staff Credentials");
		String userName=excelreader.getCellData(0, 0);
		String password=excelreader.getCellData(0, 1);
		loginpage.login(userName,password);
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="Luke";
		
		Assert.assertEquals(actualProfileName,expectedProfileName,"Profile Name mismatch");
		
	}
	
	

}
