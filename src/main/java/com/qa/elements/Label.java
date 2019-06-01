package com.qa.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends ElementBase {

   public Label(WebElement element) {
        super(element);
    }

    public Label(WebDriver driver, WebElement element) {
        super(driver, element);

    }
}
