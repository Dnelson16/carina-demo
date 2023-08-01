package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestLoginAndLogout implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Dnelson")
    public void testLoginAndLogout() {

        String username = "standard_user";
        String password = "secret_sauce";

        System.setProperty("webdriver.chrome.driver", "/Users/dylannelson16/Downloads/chromedriver_mac_arm64 2/chromedriver");
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(null);
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");


        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed on the page.");
        Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not displayed on the page.");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not displayed on the page.");

        loginPage.login(username, password);

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isPageOpened(), "Products page is not opened after login.");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productPage.isProductDisplayed("Sauce Labs Backpack"), "Product 'Sauce Labs Backpack' is not displayed.");
        softAssert.assertTrue(productPage.isProductDisplayed("Sauce Labs Bike Light"), "Product 'Sauce Labs Bike Light' is not displayed.");
        softAssert.assertTrue(productPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"), "Product 'Sauce Labs Bolt T-Shirt' is not displayed.");


        productPage.logout();


        softAssert.assertAll();
    }
}
