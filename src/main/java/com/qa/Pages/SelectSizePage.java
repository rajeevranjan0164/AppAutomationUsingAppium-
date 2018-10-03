package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectSizePage extends Base {

	public SelectSizePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='S']")
	public AndroidElement smallSize;

	public void click_smallSize() {

		smallSize.click();
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='DONE']")
	public WebElement sizeDone;
	
	public void click_sizeDone()
	{
		
		sizeDone.click();
	}

}
