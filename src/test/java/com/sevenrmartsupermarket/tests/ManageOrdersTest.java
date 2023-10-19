package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageOrdersPage;

public class ManageOrdersTest extends Base{
	
	ManageOrdersPage manageorderpage;
	LoginPage loginpage;
	
	@Test
	public void verifystatusUpdate()
	{
		loginpage=new LoginPage(driver);
		manageorderpage =new ManageOrdersPage(driver);
		loginpage.login();
		manageorderpage.clickOnManageOrderPage();
		manageorderpage.changeOrderStatus("296","Paid");
		String expectedStatus="PAID";
		Assert.assertEquals(expectedStatus,manageorderpage.statusUpdateCheck(),"Status Update Failed" );
	}
	

}
