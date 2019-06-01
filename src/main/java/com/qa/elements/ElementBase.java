package com.qa.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class ElementBase {



    private final WebElement element;
    private final WebDriver driver;

    ElementBase(WebElement element) {
        this.element = element;
        this.driver = null;
    }

    ElementBase(WebDriver driver, WebElement element) {
        this.element = element;
        this.driver = driver;
    }

    WebElement getElement() {
        return this.element;
    }

    public boolean isDisplayed() {
        boolean isDisplayed;
        try {
            isDisplayed = this.element.isDisplayed();
        } catch (NoSuchElementException var3) {
            isDisplayed = false;
        }

        return isDisplayed;
    }

    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    /** @deprecated */
    @Deprecated
    public boolean exists() {
        return this.isDisplayed();
    }

    private ExpectedCondition<Boolean> ifAppeared() {
        return (driver) -> {
            try {
                return this.isDisplayed();
            } catch (StaleElementReferenceException var3) {
                return false;
            }
        };
    }

    public boolean isAppeared() {
        return this.isAppeared(20);
    }

    public boolean isAppeared(int timeout) {
        if (this.driver != null) {
            FluentWait wait = (new WebDriverWait(this.driver, (long)timeout, 1L)).withTimeout(Duration.ofSeconds((long)timeout)).pollingEvery(Duration.ofMillis(1L));

            try {
                wait.until(this.ifAppeared());
                return true;
            } catch (TimeoutException var4) {
                return false;
            }
        } else {
            throw new UnsupportedOperationException("Driver reference required for this method, please provide driver to constructor");
        }
    }

    private ExpectedCondition<Boolean> ifDisappeared() {
        return (driver) -> {
            try {
                return !this.isDisplayed();
            } catch (StaleElementReferenceException var3) {
                return true;
            }
        };
    }

    public boolean hasDisappeared(int timeout) {
        if (this.driver != null) {
            FluentWait wait = (new WebDriverWait(this.driver, (long)timeout, 1L)).withTimeout(Duration.ofSeconds((long)timeout)).pollingEvery(Duration.ofMillis(1L));

            boolean disappeared;
            try {
                wait.until(this.ifDisappeared());
                disappeared = true;
            } catch (TimeoutException var5) {
                disappeared = false;
            }

            return disappeared;
        } else {
            throw new UnsupportedOperationException("Driver reference required for this method, please provide driver to constructor");
        }
    }

    public boolean hasDisappeared() {
        return this.hasDisappeared(20);
    }

    public String getText() {
        return this.element.getText();
    }

    public Point getLocation() {
        return this.element.getLocation();
    }

    public void click() {
        this.element.click();
    }

    public String getAttribute(String attribute) {
        return this.element.getAttribute(attribute);
    }

    public Rectangle getRect() {
        return this.element.getRect();
    }
}
