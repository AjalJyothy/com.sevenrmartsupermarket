package com.sevenrmartsupermarket.pages;

import org.checkerframework.checker.units.qual.radians;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtility generalutility;
	
	@FindBy (xpath = "//p[text()='Push Notifications']")
	WebElement pushNotificationLink;
	@FindBy (xpath = "//input[@id='title']")
	WebElement title_field;
	@FindBy(xpath  ="//input[@id='description']")
	WebElement description_field;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement send_button;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
		public PushNotificationPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void clickOnPushNotification()
		{
			pushNotificationLink.click();
		}
		public void enterTitle(String title)
		{
			title_field.sendKeys(title);
		}
		public void enterDescription(String description)
		{
			description_field.sendKeys(description);
		}
		public void clickOnSendButton()
		{
			send_button.click();
		}
		public void sendNotification(String title,String description)
		{
			enterTitle(title);
			enterDescription(description);
			clickOnSendButton();
		}
		public String checkSuccessMessage()
		{
			generalutility=new GeneralUtility();
			return generalutility.getTextOffElement(successMessage);
			
		}

}
