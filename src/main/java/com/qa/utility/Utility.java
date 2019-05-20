package com.qa.utility;

import com.qa.Base.Base;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class Utility {



    private AppiumDriver<WebElement> driver;

    protected Utility(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    /*public void scrollAndClick(String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();

    }*/

    protected AppiumDriver<WebElement> getDriver() {
        return this.driver;
    }

    protected void scrollPageUp() {
       Dimension size =  getDriver().manage().window().getSize();

    }

    protected void waitForElements(Utility page, int timeout, WebElement... elements) {
        (new WebDriverWait(this.getDriver(), (long)timeout, 1L)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected elements were not found.").until((d) -> {
            WebElement[] var2 = elements;
            int var3 = elements.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                WebElement elm = var2[var4];

                try {
                    elm.isDisplayed();
                } catch (NoSuchElementException var7) {
                    return false;
                }
            }

            return true;
        });
    }

    protected void waitForElement(Utility page, WebElement... elements) {
        this.waitForElements(page, 40, elements);
    }

    protected void waitForElement(Utility page, By... elements) {
        this.waitForElements(page, 40, elements);
    }

    protected void waitForElements(Utility page, int timeout, By... elements) {
        (new WebDriverWait(this.getDriver(), (long)timeout)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected selenium elements were not found.").until((d) -> {
            boolean success = true;
            By[] var3 = elements;
            int var4 = elements.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                By elm = var3[var5];
                List foundElements = d.findElements(elm);
                if (foundElements.isEmpty()) {
                    success = false;
                    break;
                }

                try {
                    ((WebElement)foundElements.get(0)).isDisplayed();
                } catch (NoSuchElementException var9) {
                    success = false;
                    break;
                }
            }

            return success;
        });
    }

    protected void waitForElements(Utility page, List<WebElement> elements) {
        this.waitForElements(page, 40, elements);
    }

    protected void waitForElements(Utility page, int timeout, List<WebElement> elements) {
        (new WebDriverWait(this.getDriver(), (long)timeout)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected selenium elements were not found.").until((d) -> {
            boolean success = true;
            Iterator itr = elements.iterator();
            if (!itr.hasNext()) {
                success = false;
            } else {
                WebElement elm = (WebElement)itr.next();

                try {
                    elm.isDisplayed();
                } catch (NoSuchElementException var6) {
                    success = false;
                }
            }

            return success;
        });
    }




}
