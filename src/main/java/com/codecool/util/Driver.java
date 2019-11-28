package com.codecool.util;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Driver {
    static WebDriver driver;
    private static String HUB_URL = System.getenv("HUB_URL");
    private static String BROWSER = System.getenv("BROWSER");
    //private static Platform PLATFORM = Platform.fromString(System.getenv("PLATFORM"));

    public static WebDriver getInstance() {
        if (driver == null)
            try {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName(BROWSER);
                capability.setPlatform(Platform.LINUX);
                driver = new RemoteWebDriver(new URL(HUB_URL), capability);
            } catch(MalformedURLException e) {
                System.out.println(e);
            }
        return driver;
    }

    public static void resetDriver() {
        driver.quit();
        driver = null;
    }
}