package com.sevenrmartsupermarket.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	GeneralUtility generalutility;
	
	@FindBy (xpath = "//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoyNavigationLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement mailIDField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement cancelButton;
	@FindBy (xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy (xpath = "//input[@id='un']")
	private WebElement nameFieldOnSearchPage;
	@FindBy (xpath = "//input[@id='ut']")
	private WebElement mailIDFieldOnSearchPage;
	@FindBy (xpath = "//input[@id='ph']")
	private WebElement phoneNumberFieldOnSearchPage;
	@FindBy (xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButtonOnSearchPage;
	@FindBy (xpath = "//table//tbody//tr//td[1]")
	private WebElement nameAfterSearch;
	@FindBy (xpath = "//table//tbody//tr//td[2]")
	private WebElement mailIDafterSearch;
	@FindBy (xpath = "//table//tbody//tr//td[3]")
	private WebElement phoneNumberaftersearch;
	@FindBy (xpath ="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> nameList;
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement statusMessage;
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement Message;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]")
	private List<WebElement> userNameList;
	
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnManageDeliveryBoyPage()
	{
		manageDeliveryBoyNavigationLink.click();
	}
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public void enterName(String name)
	{
		nameField.sendKeys(name);
	}
	public void enterMailID(String mailID)
	{
		mailIDField.sendKeys(mailID);
	}
	public void enterPhoneNumber(String phoneNumber)
	{
		phoneNumberField.sendKeys(phoneNumber);
	}
	public void enterAddress(String address)
	{
		addressField.sendKeys(address);
	}
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void saveButton()
	{
		pageutility=new PageUtility(driver);
		pageutility.scrollAndClick(saveButton);
	}
	public void cancelButton()
	{
		
	}
	public void newDeliveryBoyEntry(String name,String mailID,String phoneNumber,String address,String userName,String password)
	{
		clickOnNewButton();
		enterName(name);
		enterMailID(mailID);
		enterPhoneNumber(phoneNumber);
		enterAddress(address);
		enterUserName(userName);
		enterPassword(password);
		waitutility=new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(saveButton, 10);
		saveButton();
	}
	
	public void SearchInList(String name,String mailId,String phoneNumber)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));
		searchButton.click();
		nameFieldOnSearchPage.sendKeys(name);
		mailIDFieldOnSearchPage.sendKeys(mailId);
		phoneNumberFieldOnSearchPage.sendKeys(phoneNumber);
		searchButtonOnSearchPage.click();
	}
	public List<String> SearchResult()
	{
		generalutility=new GeneralUtility();
		List<String> searchResult=new ArrayList<String>();
		searchResult.add(generalutility.getTextOffElement(nameAfterSearch));
		searchResult.add(generalutility.getTextOffElement(mailIDafterSearch));
		searchResult.add(generalutility.getTextOffElement(phoneNumberaftersearch));
		return searchResult;	
	}
	public void statusChange(String memberUserName)
	{
		int index=0;
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> names=new ArrayList<String>();
		names=generalutility.getTextOfElements(userNameList);
		System.out.println(names);
		for(String name:names)
		{
			if(memberUserName.equals(name))
			{
				index++;
				break;		
			}index++;
		}
		System.out.println(index);
		WebElement status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[6]//a//span"));
		pageutility.scrollAndClick(status);
	}
	public String getStatusSuccessMessage()
	{	
		generalutility=new GeneralUtility();
		return generalutility.getTextOffElement(statusMessage); 
	}
	
	public void editDeliveryBoyMailID(String memberName,String editedmailID)
	{
		pageutility=new PageUtility(driver);
		int index=0;
		generalutility=new GeneralUtility();
		List<String> names=new ArrayList<String>();
		names=generalutility.getTextOfElements(nameList);
		for(String name:names)
		{
			if(memberName.equals(name))
			{
				System.out.println(index);
				index++;
				break;
			}index++;
		}
		WebElement editButton=driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[8] //i)[1]"));
		editButton.click();
		mailIDField.clear();
		mailIDField.sendKeys(editedmailID);
		pageutility.scrollAndClick(saveButton);
	}
	public String getEditSuccessMessage()
	{
		generalutility=new GeneralUtility();
		return generalutility.getTextOffElement(statusMessage);
	}
	
	public void deleteMember(String userName)
	{
		int index=0;
		pageutility=new PageUtility(driver);
		generalutility=new GeneralUtility();
		List<String> names=new ArrayList<String>();
		names=generalutility.getTextOfElements(userNameList);
		for(String name:names)
		{
			if(userName.equals(name))
			{
				index++;
				break;
			}index++;
		}
		System.out.println(index);
		WebElement deleteButton=driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[8]//i)[2]"));
		deleteButton.click();
		pageutility.acceptAlert();
	}
}

