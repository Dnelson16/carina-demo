package com.zebrunner.carina.demo.AndroidApplication.BasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BasePage {
    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    protected void sendKeysById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }
}
