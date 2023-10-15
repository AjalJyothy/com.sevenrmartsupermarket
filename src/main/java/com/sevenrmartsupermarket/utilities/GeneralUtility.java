package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	static Faker faker = new Faker();
	public String getTextOffElement(WebElement element) {
	return element.getText();
	}
	

	public List<String> getTextOfElements(List<WebElement> element) {
		List<String> list = new ArrayList<String>();
		for (WebElement e : element) {
			list.add(e.getText());
		}
		return list;
	}

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean is_Selected(WebElement element) {
		return element.isSelected();
	}

	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public String getElementsAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public boolean isTextPresent(WebElement element, String expectedText) {
		String data = element.getText();
		return data.contains(expectedText);
	}
	public static String randomGetFullName()
	{
		String name = faker.name().fullName();
		return name;
	}
	public static String getrandomFirstName()
	{
		String firstName = faker.name().firstName();
		return firstName;
		
	}
	public static String getRandomLastName()
	{
		String lastName = faker.name().lastName();
		return lastName;
	}
	public static String getRandomStreeetAddress()
	{
		String address=faker.address().streetAddress();
		return address;
	}
	public static String getTimeStamp()
	{
		String timeStamp;
		return timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	}
}
