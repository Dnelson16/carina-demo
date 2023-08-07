package com.zebrunner.carina.demo.AndroidApplication.BasePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MovieDetailsPage extends BasePage {

    public MovieDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public String getMovieTitle() {
        return driver.findElement(By.id("movieTitleId")).getText();
    }

    public String getReleaseDate() {
        return driver.findElement(By.id("releaseDateLabelId")).getText();
    }

    public String getSynopsis() {
        return driver.findElement(By.id("synopsisLabelId")).getText();
    }

    public String getCast() {
        return driver.findElement(By.id("castLabelId")).getText();
    }
}
