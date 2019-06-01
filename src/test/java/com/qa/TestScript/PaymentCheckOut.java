package com.qa.TestScript;

import java.net.MalformedURLException;
import java.time.Duration;

import com.qa.Base.Base;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Pages.AddressPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MainIndexPage;
import com.qa.Pages.NavigationDrower;
import com.qa.Pages.PaymentPage;
import com.qa.Pages.ReviewAndPlaceOrder;
import com.qa.Pages.SelectRegionPage;
import com.qa.Pages.SelectSizePage;
import com.qa.Pages.ShoppingCartPage;
import com.qa.Pages.SignUpOrLoginPage;
import com.qa.Pages.WomenFeaturedBrandPage;
import com.qa.utility.DataStore;
import com.qa.utility.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.TouchAction;

import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class PaymentCheckOut extends Base {

	private static AndroidDriver<AndroidElement> driver;
	SelectRegionPage selectRegionPage;
	MainIndexPage mainIndexPage;
	NavigationDrower navigationDrower;
	SignUpOrLoginPage signUpOrLoginPage;
	LoginPage loginPage;
	WomenFeaturedBrandPage womenFeaturedBrandPage;
	Utility utility;
	ShoppingCartPage shoppingCartPage;
	SelectSizePage selectSizePage;
	AddressPage addressPage;
	PaymentPage paymentPage;
	ReviewAndPlaceOrder reviewAndPlaceOrder;
	TouchAction t;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver = Capability();
		selectRegionPage = new SelectRegionPage(driver);
		mainIndexPage = new MainIndexPage(driver);
		navigationDrower = new NavigationDrower(driver);
		signUpOrLoginPage = new SignUpOrLoginPage(driver);
		loginPage = new LoginPage(driver);
		womenFeaturedBrandPage = new WomenFeaturedBrandPage(driver);
		utility = new Utility(driver);
		t = new TouchAction(driver);
		shoppingCartPage = new ShoppingCartPage(driver);
		selectSizePage = new SelectSizePage(driver);
		addressPage = new AddressPage(driver);
		paymentPage = new PaymentPage(driver);
		reviewAndPlaceOrder = new ReviewAndPlaceOrder(driver);

	}

	@Test(description = "Credit card Payment One iteam")
	public void bookProductPaymentCreditCard() throws InterruptedException {

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Singapore\"));").click();

		mainIndexPage.women.click();

		womenFeaturedBrandPage.zauenoar_click();

		//utility.scrollAndClick("*DJ* Floral Printed Tie-Wa...");
		// utility.scrollAndClick("BUY NOW");
		t.tap(PointOption.point(742, 1938)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).perform()
				.release();

		// shoppingCartPage.Click_PaymentContinue();
		selectSizePage.click_smallSize();
		selectSizePage.click_sizeDone();
		shoppingCartPage.Click_PaymentContinue();

		signUpOrLoginPage.email.click();
		loginPage.click_suggestionGmail();
		signUpOrLoginPage.email.sendKeys(DataStore.mail_id_valid);
		signUpOrLoginPage.clickContinueLogin();
		loginPage.login_password.click();
		loginPage.login_password.sendKeys(DataStore.valid_password);
		loginPage.click_login_button();
		shoppingCartPage.Click_PaymentContinue();
		addressPage.phonNumber.sendKeys(DataStore.phoneNumber);
		addressPage.houseNumber.sendKeys(DataStore.houseNumber);
		addressPage.road.sendKeys(DataStore.RoadLan);
		addressPage.city.sendKeys(DataStore.city);
		addressPage.postalCode.sendKeys(DataStore.postCode);
		addressPage.click_confirm_Address();
		paymentPage.credit_card_radio_button.click();
		paymentPage.payment_continue.click();
		paymentPage.card_number.sendKeys(DataStore.cardNumber);
		paymentPage.name_On_card.sendKeys(DataStore.cardOnName);
		paymentPage.month.click();
		paymentPage.choose_month.click();
		paymentPage.year.click();
		paymentPage.choose_year.click();

		//utility.scrollAndClick("Order Total");

		paymentPage.cvv_number.sendKeys(DataStore.cvv_number);

		paymentPage.payment_continue.click();

		reviewAndPlaceOrder.place_order.click();

	}

}
