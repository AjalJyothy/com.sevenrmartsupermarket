package com.sevenrmartsupermarket.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageOrdersPage {
	WebDriver driver;
	PageUtility pageutiliy;
	GeneralUtility generalutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-shopping-basket']")
	private WebElement manageOrdersPageLink;	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement orderIDField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchPageSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
	private WebElement changeStatusButton;
	@FindBy(xpath = "(//button[@class='btn btn-info'])[1]")
	private WebElement updateButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[6]//span")
	private WebElement dispalyedStatus;
	
	
	

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOrderPage() {
		manageOrdersPageLink.click();
	}

	public void changeOrderStatus(String orderID,String status) {
	
		generalutility = new GeneralUtility();
		pageutiliy=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		searchInList(orderID);
		pageutiliy.scrollAndClick(changeStatusButton);
		WebElement statusDropDown=driver.findElement(By.xpath("//select[@onchange='show_cancel("+orderID+")']"));
		pageutiliy.select_ByVisibleText(statusDropDown, status);
		updateButton.click();
	}
	
	public void searchInList(String orderID)
	{
		searchButton.click();
		orderIDField.sendKeys(orderID);
		searchPageSearchButton.click();
	}

	public String statusUpdateCheck(String orderID) {
		generalutility=new GeneralUtility();
		searchInList(orderID); 
		return generalutility.getTextOffElement(dispalyedStatus);
	}

}
