package com.qa.utility;

import com.qa.Base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class Utility extends Base {


    private static AndroidDriver<AndroidElement> driver;

    public Utility(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /*public void scrollAndClick(String visibleText) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();

    }*/

    protected AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    protected void scrollPageUp() {
        Dimension size = getDriver().manage().window().getSize();

    }

    protected void waitForElements(Utility page, int timeout, WebElement... elements) {
        (new WebDriverWait(this.getDriver(), (long) timeout, 1L)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected elements were not found.").until((d) -> {
            WebElement[] var2 = elements;
            int var3 = elements.length;

            for (int var4 = 0; var4 < var3; ++var4) {
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
        (new WebDriverWait(this.getDriver(), (long) timeout)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected selenium elements were not found.").until((d) -> {
            boolean success = true;
            By[] var3 = elements;
            int var4 = elements.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                By elm = var3[var5];
                List foundElements = d.findElements(elm);
                if (foundElements.isEmpty()) {
                    success = false;
                    break;
                }

                try {
                    ((WebElement) foundElements.get(0)).isDisplayed();
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
        (new WebDriverWait(this.getDriver(), (long) timeout)).withMessage("Timed out navigating to [" + page.getClass().getName() + "]. Expected selenium elements were not found.").until((d) -> {
            boolean success = true;
            Iterator itr = elements.iterator();
            if (!itr.hasNext()) {
                success = false;
            } else {
                WebElement elm = (WebElement) itr.next();

                try {
                    elm.isDisplayed();
                } catch (NoSuchElementException var6) {
                    success = false;
                }
            }

            return success;
        });
    }

    /**
     * This method scrolls based upon the passed parameters
     *
     * @param startx - the starting x position
     * @param starty - the starting y position
     * @param endx   - the ending x position
     * @param endy   - the ending y position
     * @author Bill Hileman
     */
    public void scroll(int startx, int starty, int endx, int endy) {

        TouchAction touchAction = new TouchAction(driver);

        touchAction.longPress(point(startx, starty))
                .moveTo(point(endx, endy))
                .release()
                .perform();

    }

    /**
     * This method does a swipe upwards
     *
     * @throws Exception
     * @author Bill Hileman
     */
    public void scrollDown() throws Exception {

        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //Starting y location set to 80% of the height (near bottom)
        int starty = (int) (size.height * 0.80);

        Double scrollHightStart = size.getHeight() * 0.5;
        int scrollStart = scrollHightStart.intValue();
        //Ending y location set to 20% of the height (near top)
        int endy = (int) (size.height * 0.20);

        Double scrollHightEnd = size.getHeight() * 0.2;
        int end = scrollHightEnd.intValue();

        //x position set to mid-screen horizontally
        int startx = (int) size.width / 2;

        scroll(startx, starty, startx, endy);

    }

    /**
     * This method does a swipe left
     *
     * @throws Exception
     * @author Bill Hileman
     */
    public void swipeLeft() throws Exception {

        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //Starting x location set to 95% of the width (near right)
        int startx = (int) (size.width * 0.95);
        //Ending x location set to 5% of the width (near left)
        int endx = (int) (size.width * 0.05);
        //y position set to mid-screen vertically
        int starty = size.height / 2;

        scroll(startx, starty, endx, starty);

    }

    /**
     * This method does a swipe right
     *
     * @throws Exception
     * @author Bill Hileman
     */
    public void swipeRight() throws Exception {

        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //Starting x location set to 5% of the width (near left)
        int startx = (int) (size.width * 0.05);
        //Ending x location set to 95% of the width (near right)
        int endx = (int) (size.width * 0.95);
        //y position set to mid-screen vertically
        int starty = size.height / 2;

        scroll(startx, starty, endx, starty);

    }

    /**
     * This method does a swipe downwards
     *
     * @throws Exception
     * @author Bill Hileman
     */
    public void scrollUp() throws Exception {

        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();

        //Starting y location set to 20% of the height (near bottom)
        int starty = (int) (size.height * 0.20);
        //Ending y location set to 80% of the height (near top)
        int endy = (int) (size.height * 0.80);
        //x position set to mid-screen horizontally
        int startx = size.width / 2;

        scroll(startx, starty, startx, endy);


    }

    public void swipeDown(int howManySwipes) {
        Dimension size = driver.manage().window().getSize();
        // calculate coordinates for vertical swipe
        int startVerticalY = (int) (size.height * 0.8);
        int endVerticalY = (int) (size.height * 0.21);
        int startVerticalX = (int) (size.width / 2.1);
        try {
            for (int i = 1; i <= howManySwipes; i++) {
                new TouchAction<>(driver).press(point(startVerticalX, endVerticalY))
                        .waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, startVerticalY))
                        .release().perform();
            }
        } catch (Exception e) {
            //print error or something
        }
    }
}
