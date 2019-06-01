package com.qa.Pages;

import com.qa.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends Base {
	
	AndroidDriver<AndroidElement> driver;

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(id="com.zilingo.users:id/textView")
	public WebElement login_password;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='LOGIN']")
	public WebElement login_button;


	
	public void click_login_button()
	{
		
		login_button.click();
	}
	
	@AndroidFindBy(id="com.google.android.gms:id/cancel")
	public AndroidElement suggestionGmail;
	
	public void click_suggestionGmail()
	{
		
		suggestionGmail.click();
	}

}
