package com.qa.TestScript;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.Base;
import com.qa.Pages.MainIndexPage;
import com.qa.Pages.NavigationDrower;
import com.qa.Pages.SelectRegionPage;
import com.qa.Pages.SignUpOrLoginPage;
import com.qa.utility.DataStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignUpTestScript extends Base {

	private static AndroidDriver<AndroidElement> driver;
	SelectRegionPage selectRegionPage;
	MainIndexPage mainIndexPage;
	NavigationDrower navigationDrower;
	SignUpOrLoginPage signUpOrLoginPage;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver = Capability();
		selectRegionPage = new SelectRegionPage(driver);
		mainIndexPage = new MainIndexPage(driver);
		navigationDrower = new NavigationDrower(driver);
		signUpOrLoginPage = new SignUpOrLoginPage(driver);

	}

	@Test(priority = 1, description = "No need to Enter any Email id and click Continue Login")
	public void without_Enter_Email_Id_Verify() {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Singapore\"));").click();
		mainIndexPage.ClickDrowerButton();
		navigationDrower.click_login_create_account();
		signUpOrLoginPage.clickContinueLogin();
		String exceptedErrorMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertEquals(DataStore.Actual_error_Email_id, exceptedErrorMessage,
				"Eamil error message is not displaying");
	}

	@Test(priority = 2, description = "Enter valid Email id and click Continue Login")
	public void valid_Enter_Email_Id_Verify() {
		// signUpOrLoginPage.email.clear();
		// driver.hideKeyboard();

		signUpOrLoginPage.email.sendKeys(DataStore.mail_id_valid);
		signUpOrLoginPage.clickContinueLogin();
		String nextPageMessage = signUpOrLoginPage.text_created_account.getText();
		Assert.assertTrue(nextPageMessage.contains(DataStore.register_page_data_verfiy));
		signUpOrLoginPage.email.clear();

	}

	@Test(priority = 3, description = " Without enter any name only email id is there")
	public void Without_Enter_name() {
		signUpOrLoginPage.click_Create_account_button();
		String nextPageMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertEquals(DataStore.Acutual_error_name, nextPageMessage, "name error message is not getting");
	}

	@Test(priority = 4, description = "Enter name in the field ")
	public void Enter_name() {
		signUpOrLoginPage.fullName.sendKeys(DataStore.name);
		signUpOrLoginPage.click_Create_account_button();
		String nextPageMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertEquals(DataStore.Actual_error_phone_number, nextPageMessage, "phone error message is not getting");

	}

	@Test(priority = 5, description = " Enter phone number in the field")
	public void phone_number() {
		signUpOrLoginPage.mobileNumber.sendKeys(DataStore.number);
		signUpOrLoginPage.click_Create_account_button();
		String nextPageMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertEquals(DataStore.Actual_error_without_enter_password, nextPageMessage,
				"password incorrect is not getting");

	}

	@Test(priority = 6, description = "Enter less word password in the field")
	public void less_Word_Password() {
		signUpOrLoginPage.password.sendKeys(DataStore.less_password);
		signUpOrLoginPage.click_Create_account_button();
		String nextPageMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertEquals(DataStore.Actual_error_with_enter_password, nextPageMessage,
				"Enter 6 letter password is not showing");

	}

	@Test(priority = 7, description = "verfiy home page")
	public void full_Word_Password() {
		signUpOrLoginPage.password.sendKeys(DataStore.Full_password);
		signUpOrLoginPage.click_Create_account_button();
		String expected = mainIndexPage.getWovenText();
		Assert.assertEquals(DataStore.womenText, expected);

	}
}
