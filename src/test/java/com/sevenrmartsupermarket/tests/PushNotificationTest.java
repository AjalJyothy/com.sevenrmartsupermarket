package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.InspectExecResponse.Container;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base {
	
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	ExcelReader excelreader=new ExcelReader();
	
	@Test
	public void verifyPushNotificationClickSuccessMessage()
	{
		pushnotificationpage=new PushNotificationPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		pushnotificationpage.clickOnPushNotification();
		excelreader.setExcelFile("NotificationData","Push Notification");
		String title=excelreader.getCellData(0, 0);
		String description=excelreader.getCellData(1, 0);
		pushnotificationpage.sendNotification(title, description);
		String expectedMessage="Message send successfully";
		String actualSuccessMessage=pushnotificationpage.checkSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedMessage));
	}
	
	

}
