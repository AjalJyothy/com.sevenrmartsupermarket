package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	WaitUtility waitutility;
	GeneralUtility generalutility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersLink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeSelection;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement saveButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> namesList;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement userNameDropDown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logOut;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsersPage() {
		adminUsersLink.click();
	}

	public void adminUsersNewButtonClick() {
		newButton.click();
	}

	public void enterUserName(String username) {
		usernameField.sendKeys(username);
		;
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUserType(String usertype) {
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(userTypeSelection, usertype);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void newAdminUserCreation(String username, String password, String usertype) {
		adminUsersNewButtonClick();
		enterUserName(username);
		enterPassword(password);
		selectUserType(usertype);
		waitutility = new WaitUtility(driver);
		waitutility.waitForElementToBeClickable(saveButton, 10);
		clickOnSaveButton();

	}

	public void deactivateUser(String personName) {
		int index = 0;
		generalutility = new GeneralUtility();
		pageutility = new PageUtility(driver);
		List<String> names = new ArrayList();
		names = generalutility.getTextOfElements(namesList);
		for (String name : names) {
			if (personName.equals(name)) {
				index++;
				break;
			}
			index++;
		}
		WebElement deactivateButton = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + index + "]//td[5]//a[1]"));
		pageutility.scrollAndClick(deactivateButton);
	}

	public void logout() {
		userNameDropDown.click();
		logOut.click();
	}
}
