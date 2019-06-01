package com.qa.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends ElementBase {

    public Button(WebElement element) {
        super(element);
    }

    public Button(WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
