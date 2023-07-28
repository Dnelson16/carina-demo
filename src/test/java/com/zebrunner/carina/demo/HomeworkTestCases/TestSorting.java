package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.demo.gui.pages.android.ProductPage;
import com.zebrunner.carina.demo.mobile.gui.pages.android.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TestSorting {

    @Test
    public void testSorting() {

        String username = "standard_user";
        String password = "secret_sauce";


        WebDriver driver = null;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username, password);

        ProductPage productsPage = new ProductPage(driver);
        productsPage.selectSortingOption("Name (Z to A)");


        List<String> productNames = productsPage.getProductNames();
        Assert.assertTrue(productsPage.isProductsSortedDesc(productNames), "Products are not sorted in descending order by name.");
    }
}

