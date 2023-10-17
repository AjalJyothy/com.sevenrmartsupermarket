package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	ExcelReader excelreader=new ExcelReader();
	SoftAssert softassert=new SoftAssert();
	
	@Test
	public void verifyNewDeliveryBoyEntry()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoyPage();
		excelreader.setExcelFile("ManageDeliveryBoyData", "Delivery Boy Details");
		String name = excelreader.getCellData(0, 0);
		String mailID = excelreader.getCellData(1, 0);
		String phoneNumber = excelreader.getCellData(2, 0);
		String address = excelreader.getCellData(3, 0);
		String userName = excelreader.getCellData(4, 0);
		String password = excelreader.getCellData(5, 0);
		managedeliveryboypage.newDeliveryBoyEntry(name,mailID,phoneNumber,address,userName,password);
		managedeliveryboypage.SearchInList(name, mailID, phoneNumber);
		List<String> expected_search_result=new ArrayList<String>();
		expected_search_result.add(name);
		expected_search_result.add(mailID);
		expected_search_result.add(phoneNumber);
		Assert.assertEquals(managedeliveryboypage.SearchResult(), expected_search_result,"Member not found");		
	}
	@Test
	public void verifyNewUserSearch() 
	{
		
	}
	
	@Test
	public void verifyDeliveryBoyStatusChangeOfMember()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoyPage();
		managedeliveryboypage.statusChange("Rahul_R");
		String expectedSuccessMessage="Alert!\r\n"
				+ "Delivery Boy Status Changed Successfully";
		
		Assert.assertEquals(managedeliveryboypage.getStatusSuccessMessage(),expectedSuccessMessage);
	}
	

	@Test
	public void verifyEditDeliveryBoyDetail()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoyPage();
		managedeliveryboypage.editDeliveryBoyDetail("Joy");	
		managedeliveryboypage.SearchInList("Joy", "joy123@gmail.com", "9555556785");
		List<String> expected_search_result=new ArrayList<String>();
		expected_search_result.add("Joy");
		expected_search_result.add("joy123@gmail.com");
		expected_search_result.add("9555556785");
		Assert.assertEquals(managedeliveryboypage.SearchResult(), expected_search_result,"Member not found");			
	}
	
	@Test
	public void verifyMemberDeletion()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboypage=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoyPage();
		managedeliveryboypage.deleteMember("Rahul_R");
		//managedeliveryboypage.SearchInList("Joy","joy123@gmail.com","9555556785");	
	}
	
	
}
