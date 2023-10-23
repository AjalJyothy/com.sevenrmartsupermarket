package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.listeners.RetryAnalyser;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.Screenshot;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();

	@Test(priority=1,groups= {"Sanity Test","Regression Test"},retryAnalyzer = RetryAnalyser.class)
	public void verifyNewAdminUsersCreation() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		adminuserspage.clickOnAdminUsersPage();
		excelreader.setExcelFile("NewAdminUserDetails", "Admin Details");
		String username = excelreader.getCellData(0, 0);
		String password = excelreader.getCellData(1, 0);
		String usertype = excelreader.getCellData(2, 0);
		adminuserspage.newAdminUserCreation(username, password, usertype);
		adminuserspage.logout();
		loginpage.login(username, password);
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="Jams";
		Assert.assertEquals(actualProfileName,expectedProfileName,"Profile Name mismatch");

	}
	@Test(groups="Sanity Test")
	public void verifyUserDeactivation() {
		loginpage = new LoginPage(driver);
		adminuserspage = new AdminUsersPage(driver);
		loginpage.login();
		adminuserspage.clickOnAdminUsersPage();
		adminuserspage.deactivateUser("Janaki");		
	}
	
}
