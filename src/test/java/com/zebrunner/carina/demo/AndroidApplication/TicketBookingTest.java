package com.zebrunner.carina.demo.AndroidApplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TicketBookingTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Your_Device_Name");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "path/to/RegalCinemas.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void testTicketBookingAndCheckout() {
        // Search for a specific movie or select a movie from the home screen
        String movieToBook = "Avengers: Endgame";
        driver.findElement(By.id("movieCardId")).click();

        driver.findElement(By.id("bookTicketsButtonId")).click();

        String expectedMovieTitle = "Avengers: Endgame";
        String expectedShowtime = "2023-07-18 20:00";
        int expectedTicketQuantity = 3;
        String actualMovieTitle = driver.findElement(By.id("checkoutMovieTitleId")).getText();
        String actualShowtime = driver.findElement(By.id("checkoutShowtimeLabelId")).getText();
        int actualTicketQuantity = Integer.parseInt(driver.findElement(By.id("checkoutTicketQuantityId")).getText());
        Assert.assertEquals(actualMovieTitle, expectedMovieTitle);
        Assert.assertEquals(actualShowtime, expectedShowtime);
        Assert.assertEquals(actualTicketQuantity, expectedTicketQuantity);

        // Proceed with the checkout process
        driver.findElement(By.id("proceedToCheckoutButtonId")).click();

        // Verify that the confirmation page is displayed after the checkout
        Assert.assertTrue(driver.findElement(By.id("confirmationPageId")).isDisplayed());
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}

