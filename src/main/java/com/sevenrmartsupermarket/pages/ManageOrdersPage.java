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
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> orderIDList;
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement statusSelectDropDown;
	@FindBy(xpath = "//button[@name='Update_st']")
	private WebElement updateStatusButton;
	

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageOrderPage() {
		manageOrdersPageLink.click();
	}

	public void changeOrderStatus(String orderID,String status) {
		int index = 0;
		generalutility = new GeneralUtility();
		pageutiliy=new PageUtility(driver);
		waitutility=new WaitUtility(driver);
		List<String> orderIDs = new ArrayList<String>();
		orderIDs = generalutility.getTextOfElements(orderIDList);
		for (String ID : orderIDs) {
			if (orderID.equals(ID)) {
				index++;
				break;
			}index++;
		}
		WebElement changeStatusButton=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+index+"]//td[6]//a[contains(text(),'Change Status')]"));
		pageutiliy.scrollAndClick(changeStatusButton);
		waitutility.ImplicitWait();
		pageutiliy.select_ByVisibleText(statusSelectDropDown,status);
		updateStatusButton.click();
		
		
	}

	public void statusUpdate() {

	}

}
