package com.zebrunner.carina.demo.AndroidApplication;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UserLoginRewardsTest {
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
    @MethodOwner(owner = "Dnelson")
    public void testUserLoginAndRewardsPoints() {
        Assert.assertTrue(driver.findElement(By.id("loginScreenId")).isDisplayed());

        driver.findElement(By.id("usernameFieldId")).sendKeys("your_username");
        driver.findElement(By.id("passwordFieldId")).sendKeys("your_password");
        driver.findElement(By.id("loginButtonId")).click();

        Assert.assertTrue(driver.findElement(By.id("profilePageId")).isDisplayed());

        String expectedName = "Your Name";
        String expectedEmail = "your.email@example.com";
        String actualName = driver.findElement(By.id("userNameLabelId")).getText();
        String actualEmail = driver.findElement(By.id("userEmailLabelId")).getText();

        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualEmail, expectedEmail);

        int expectedRewardsPoints = 100;
        int actualRewardsPoints = Integer.parseInt(driver.findElement(By.id("rewardsPointsLabelId")).getText());
        Assert.assertEquals(actualRewardsPoints, expectedRewardsPoints);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

