package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectRegionPage {

	AndroidDriver<AndroidElement> driver;
	public SelectRegionPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidBy(xpath="//android.widget.TextView[@text='Singapore']")
	public List<WebElement> singapore;
	
	/*public void clickSingapore()
	{
		singapore.click();
	}*/

}
