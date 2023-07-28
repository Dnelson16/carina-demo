package com.zebrunner.carina.demo.gui.pages.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    private final WebDriver driver;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@id='signupButton']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[@id='loginLink']")
    private WebElement loginLink;



    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public boolean isSignUpPageDisplayed() {
        return driver.findElement(By.xpath("//h1[text()='Sign Up']")).isDisplayed();
    }

    public void registerUser(String testuser123, String password123, String mail) {
    }

    public boolean isSignUpButtonVisible() {
        return false;
    }

    public boolean isLogoutButtonVisible() {
        return false;
    }

    public boolean isWelcomeMessageDisplayed() {
        return false;
    }
}

