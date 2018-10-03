package com.qa.TestScript;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Base.Base;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MainIndexPage;
import com.qa.Pages.NavigationDrower;
import com.qa.Pages.SelectRegionPage;
import com.qa.Pages.SignUpOrLoginPage;
import com.qa.utility.DataStore;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTestScript extends Base {

	private static AndroidDriver<AndroidElement> driver;
	SelectRegionPage selectRegionPage;
	MainIndexPage mainIndexPage;
	NavigationDrower navigationDrower;
	SignUpOrLoginPage signUpOrLoginPage;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver = Capability();
		selectRegionPage = new SelectRegionPage(driver);
		mainIndexPage = new MainIndexPage(driver);
		navigationDrower = new NavigationDrower(driver);
		signUpOrLoginPage = new SignUpOrLoginPage(driver);
		loginPage = new LoginPage(driver);

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

	@Test(priority = 2, description = "Enter Invalid Email id and click Continue Login")
	public void invalid_Enter_Email_Id_Verify() {

		signUpOrLoginPage.email.click();
		loginPage.click_suggestionGmail();
		signUpOrLoginPage.email.sendKeys(DataStore.mail_id_invalid);
		signUpOrLoginPage.clickContinueLogin();
		String exceptedErrorMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertTrue(exceptedErrorMessage.contains(DataStore.invalid_mail_id_message));

	}

	@Test(priority = 3, description = "Enter Valid Email id and click Continue Login")
	public void valid_Enter_Email_Id_Verify() {
		signUpOrLoginPage.email.clear();

		// signUpOrLoginPage.email.clear();
		signUpOrLoginPage.email.sendKeys(DataStore.mail_id_valid);
		signUpOrLoginPage.clickContinueLogin();
	}

	@Test(priority = 4, description = "Enter Invalid Password")
	public void invalid_password() {

		loginPage.login_password.sendKeys(DataStore.invalid_password);
		loginPage.click_login_button();
		String errorPageMessage = signUpOrLoginPage.getinputErrorEmailMessage();
		Assert.assertTrue(errorPageMessage.contains(DataStore.Actual_invalid_password_error_message));
		signUpOrLoginPage.email.clear();
	}

	@Test(priority = 5, description = "Enter valid Password")
	public void valid_password() {

		loginPage.login_password.sendKeys(DataStore.valid_password);
		loginPage.click_login_button();
		String text = mainIndexPage.getWovenText();
		Assert.assertEquals(text, DataStore.womenText);

	}
}
