package com.zebrunner.carina.demo.AndroidApplication;


import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.AndroidApplication.BasePages.MovieDetailsPage;
import com.zebrunner.carina.demo.AndroidApplication.BasePages.SearchPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class MovieSearchTest {
    private AndroidDriver driver;
    private SearchPage searchPage;
    private MovieDetailsPage movieDetailsPage;
    private Object MovieTestData;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Your_Device_Name");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "path/to/RegalCinemas.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        searchPage = new SearchPage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
    }

    @Test
    @MethodOwner(owner = "Dnelson")
    public void testMovieSearchAndDetails() {
        String movieToSearch = "Spider-Man";

        searchPage.searchMovie(movieToSearch);
        movieDetailsPage = new MovieDetailsPage(driver);

        String actualTitle = movieDetailsPage.getMovieTitle();
        String actualReleaseDate = movieDetailsPage.getReleaseDate();
        String actualSynopsis = movieDetailsPage.getSynopsis();
        String actualCast = movieDetailsPage.getCast();

        String expectedTitle = movieToSearch;
        String expectedDetails = String.valueOf(MovieTestData.getClass());
        String[] expectedParts = expectedDetails.split(":");

        assertEquals(actualTitle, expectedTitle, "Movie title doesn't match");
        assertEquals(actualReleaseDate, expectedParts[0], "Release date doesn't match");
        assertEquals(actualSynopsis, expectedParts[1], "Synopsis doesn't match");
        assertEquals(actualCast, expectedParts[2], "Cast doesn't match");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}