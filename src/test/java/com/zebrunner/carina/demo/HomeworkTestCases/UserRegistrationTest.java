package com.zebrunner.carina.demo.HomeworkTestCases;

import com.zebrunner.carina.demo.gui.pages.SauceDemo.HomePages;
import com.zebrunner.carina.demo.gui.pages.SauceDemo.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//https://www.demoblaze.com/

public class UserRegistrationTest {

    private WebDriver driver;
    private HomePages homePages;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePages = new HomePages(driver);
    }

    @Test
    public void testUserRegistration() {

        homePages.open();
        homePages.clickSignUpLink();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.registerUser("testuser123", "password123", "testuser123@example.com");


        Assert.assertFalse(signUpPage.isSignUpButtonVisible(), "Sign Up button is still visible.");
        Assert.assertTrue(signUpPage.isLogoutButtonVisible(), "User is not logged in.");
        Assert.assertTrue(signUpPage.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
