package com.qa.Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.optional.Cab;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver driver;

	public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException {

		File appDir = new File(System.getProperty("user.dir"), "/apps");
        File app = new File(appDir, "com.zilingo.users_2018-09-21.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); //Android Device
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		capabilities.setCapability("appPackage", "com.zilingo.users");
		capabilities.setCapability("appActivity", "com.zilingo.users.launcher_activity.LauncherActivity");
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, "false");
		capabilities.setCapability("autoDismissAlerts", true);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		return driver;

	}

}
