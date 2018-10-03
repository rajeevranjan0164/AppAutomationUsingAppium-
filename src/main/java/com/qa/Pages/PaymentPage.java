package com.qa.Pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.Base.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage extends Base {
	
	public PaymentPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.RadioButton[@index='0']")
	public AndroidElement credit_card_radio_button;
	
	public void click_credit_card_radio_button()
	{
		
		credit_card_radio_button.click();
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Card Number']")
	public AndroidElement card_number;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Name on card']")
	public AndroidElement name_On_card;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Month']")
	public AndroidElement month;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Year']")
	public AndroidElement year;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='06']")
	public AndroidElement choose_month;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='2022']")
	public AndroidElement choose_year;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='CVV']")
	public AndroidElement cvv_number;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='CONTINUE']")
	public AndroidElement payment_continue;
	
	
	
	
	
	

}
