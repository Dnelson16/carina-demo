package com.zebrunner.carina.demo.AndroidApplication;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidApp {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

