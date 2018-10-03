package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewAndPlaceOrder extends Base {
	
	public ReviewAndPlaceOrder(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='PLACE ORDER']")
	
	public AndroidElement place_order;

}
