package com.qa.Pages;

import com.qa.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShoppingCartPage extends Base {
	
	
	public ShoppingCartPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='CONTINUE']")
	public WebElement paymentContinue;
	
	public void Click_PaymentContinue()
	{
		
		paymentContinue.click();
	}
	

}
