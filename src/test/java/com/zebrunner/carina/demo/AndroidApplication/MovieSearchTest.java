package com.zebrunner.carina.demo.AndroidApplication;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.MobileBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MovieSearchTest {
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
    public void testMovieSearchAndDetails() {

        Assert.assertTrue(driver.findElement(By.id("searchBarId")).isDisplayed());


        String movieToSearch = "Spider-Man";
        driver.findElement(By.id("searchBarId")).sendKeys(movieToSearch);

        driver.findElement(MobileBy.AndroidUIAutomator("text(\"" + movieToSearch + "\")")).click();

        String expectedTitle = "Spider-Man";
        String expectedReleaseDate = "2023-07-18";
        String expectedSynopsis = "A superhero film based on the Marvel Comics character Spider-Man.";
        String expectedCast = "Tom Holland, Zendaya, Jacob Batalon, Marisa Tomei";
        String actualTitle = driver.findElement(By.id("movieTitleId")).getText();
        String actualReleaseDate = driver.findElement(By.id("releaseDateLabelId")).getText();
        String actualSynopsis = driver.findElement(By.id("synopsisLabelId")).getText();
        String actualCast = driver.findElement(By.id("castLabelId")).getText();

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualReleaseDate, expectedReleaseDate);
        Assert.assertEquals(actualSynopsis, expectedSynopsis);
        Assert.assertEquals(actualCast, expectedCast);
    }
    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
