package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.utility.DataStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpOrLoginPage {
	DataStore dataStore;

	AndroidDriver<AndroidElement> driver;

	public SignUpOrLoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		dataStore = new DataStore();
	}

	@AndroidFindBy(id = "com.zilingo.users:id/textView")
	public WebElement email;

	public void sendEmailId() {
		email.sendKeys(dataStore.mail_id_valid);
	}

	@AndroidFindBy(id = "com.zilingo.users:id/next_button")
	public AndroidElement continueLogin;

	public void clickContinueLogin() {
		continueLogin.click();
	}

	@AndroidFindBy(id = "com.zilingo.users:id/error_message")
	public AndroidElement inputErrorEmailMessage;

	public String getinputErrorEmailMessage() {
		return inputErrorEmailMessage.getText();
	}

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement fullName;

	public String getFullName() {
		return fullName.getText();
	}

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement mobileNumber;

	public String getMobileNumber() {

		return mobileNumber.getText();
	}

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public AndroidElement password;

	public String getPassword() {

		return password.getText();
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Create account']")
	public WebElement text_created_account;
	
	@AndroidFindBy(id="com.zilingo.users:id/create_account_button")
	public AndroidElement create_account_button;
	
	public void click_Create_account_button()
	{
		
		create_account_button.click();
	}
	
	
}
