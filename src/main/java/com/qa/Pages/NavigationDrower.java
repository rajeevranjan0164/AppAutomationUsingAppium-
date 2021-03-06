package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NavigationDrower {

	AndroidDriver<AndroidElement> driver;

	public NavigationDrower(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.zilingo.users:id/chevron")
	public WebElement login_create_account;

	public void click_login_create_account() {
		login_create_account.click();
	}

}
