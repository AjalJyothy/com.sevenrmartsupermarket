package com.sevenrmartsupermarket.utilities;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void jsScrollintoView(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView()", element);

	}

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void select_Byvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void getAlertText() {
		actions = new Actions(driver);
		System.out.println(driver.switchTo().alert().getText());

	}

	public void acceptAlert() {
		actions = new Actions(driver);
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		actions = new Actions(driver);
		driver.switchTo().alert().dismiss();
	}

	public void cssValue_Color(WebElement element) {
		System.out.println(element.getCssValue("color"));
	}

	public String cssValue_BackgroundColor(WebElement element) {
		String color=element.getCssValue("background-color");
		return color;
	}

	public String cssValue_FontSize(WebElement element) {
		String fontSize=element.getCssValue("font-size");
		return fontSize;
	}

	public String cssValue_FontStyle(WebElement element) {
		String fontStyle=element.getCssValue("font-style");
		return fontStyle;
	}

	public void switchToWindow() {
		Set<String> window_ids = driver.getWindowHandles();
		String parent_window = driver.getWindowHandle();
		for (String id : window_ids) {

			if (!parent_window.equals(id)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void DragAndDrop(WebElement element, WebElement elementPosition) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, elementPosition).build().perform();
	}
	
	public void doubleClick(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	public void rightClick(WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void scrollAndClick(WebElement element) {
		int y = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 5;
		}
	}
	
	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {

			return false;
		}
	}

}
