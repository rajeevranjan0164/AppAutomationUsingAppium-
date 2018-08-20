package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainIndexPage {
	
	AndroidDriver<AndroidElement> driver;
	public MainIndexPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		

	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open Navigation Drawer']")
	public WebElement drowerButton;
	
	public void ClickDrowerButton()
	{
		
		drowerButton.click();
	}

}
