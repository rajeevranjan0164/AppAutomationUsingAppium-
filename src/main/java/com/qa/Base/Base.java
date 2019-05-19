package com.qa.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

	public static AndroidDriver driver;
	public static Properties prop;

	/*
	 * TestBase class constructor : used to initialize the Properties object to
	 * fetch config (env) variables from config.properties file
	 */
	public Base() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException {

		File appDir = new File(System.getProperty("user.dir"), "/apps");
        File app = new File(appDir, "android.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName")); //Android Device
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("platformVersion"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "platformName");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability("appPackage", "com.zilingo.users");
		capabilities.setCapability("appActivity", "com.zilingo.users.launcher_activity.LauncherActivity");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		return driver;

	}


}
