package com.zebrunner.carina.demo.AndroidApplication.BasePages;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage extends BasePage {

    public SearchPage(AndroidDriver driver) {
        super(driver);
    }

    public void searchMovie(String movieName) {
        sendKeysById("searchBarId", movieName);
        clickById("searchButtonId");
    }
}
