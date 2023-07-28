package com.zebrunner.carina.demo.gui.pages.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePages {

    private final WebDriver driver;

    private final By signUpLink = By.xpath("//a[text()='Sign Up']");
    private final By laptopsSectionLink = By.xpath("//a[text()='Laptops']");
    private final By tabletsSectionLink = By.xpath("//a[text()='Tablets']");
    private final By cartItemCount = By.xpath("//span[@id='cart-count']");

    public HomePages(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public void navigateToLaptopsSection() {
        driver.findElement(laptopsSectionLink).click();
    }

    public void navigateToTabletsSection() {
        driver.findElement(tabletsSectionLink).click();
    }

    public int getCartItemCount() {
        return Integer.parseInt(driver.findElement(cartItemCount).getText());
    }
}
