package com.qa.Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddressPage {
	
	public AddressPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']/TextInputLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement phonNumber;
	
	
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/TextInputLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement houseNumber;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/TextInputLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement road;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='4']/android.widget.RelativeLayout[@index='0']/TextInputLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement city;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='5']/android.widget.RelativeLayout[@index='0']/TextInputLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement postalCode;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='CONFIRM ADDRESS']")
	public AndroidElement confirm_Address;
	
	public void click_confirm_Address()
	{
		confirm_Address.click();
	}
	
	
}
