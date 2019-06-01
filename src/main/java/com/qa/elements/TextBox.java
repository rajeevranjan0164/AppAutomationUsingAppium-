package com.qa.elements;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBox extends ElementBase {
    private static final Logger logger = LogManager.getLogger(TextBox.class);

    public TextBox(WebElement element) {
        super(element);
    }

    public TextBox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    /*public void setText(String text) {
        logger.info("Entering text \"{}\"...", new Object[]{text});
        this.getElement().clear();
        this.getElement().sendKeys(new CharSequence[]{text});
    }*/

    public void clear() {
        logger.info("Clearing text box");
        this.getElement().clear();
    }

    /*public void setTextIfNotExists(String text) {
        if (Objects.equals(this.getElement().getText(), text))
            logger.info("Text \"{}\" already exists in TextBox, no need to enter", new Object[]{text});
        else {
            this.setText(text);
        }
    }*/
}
