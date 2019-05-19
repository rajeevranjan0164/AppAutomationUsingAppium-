package com.qa.Pages;

import com.qa.Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WomenFeaturedBrandPage extends Base {
	
	public WomenFeaturedBrandPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
		@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']/android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.ImageView[@index='0']") 
		public AndroidElement zauenoar;
		
		public void zauenoar_click()
		{
			
			zauenoar.click();
		}
		
		@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
		public WebElement paymentContinue;
		
		public void Click_PaymentContinue()
		{
			
			paymentContinue.click();
		}
		

	}
	
	


