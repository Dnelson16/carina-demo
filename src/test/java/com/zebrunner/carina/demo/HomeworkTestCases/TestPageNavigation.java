package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageNavigation {

    @Test
    @MethodOwner(owner = "Dnelson")
    public void testPageNavigation() {

        String username = "standard_user";
        String password = "secret_sauce";

        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);

        ProductPage productPage = new ProductPage(driver);


        Assert.assertTrue(productPage.isPageOpened(), "Products page is not opened after login.");

        productPage.openInventoryPage();
        Assert.assertTrue(productPage.isPageOpened(), "Inventory page is not opened.");

        productPage.openCart();
        Assert.assertTrue(productPage.isPageOpened(), "Cart page is not opened.");

        productPage.openMenu();
        productPage.openAboutPage();
        Assert.assertTrue(productPage.isPageOpened(), "About page is not opened.");

        productPage.openMenu();
        productPage.openResetAppState();
        Assert.assertTrue(productPage.isPageOpened(), "Reset App State page is not opened.");
    }
}

