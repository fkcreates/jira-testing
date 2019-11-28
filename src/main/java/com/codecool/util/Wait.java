package com.codecool.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends WebDriverWait {
    static WebDriver driver = Driver.getInstance();
    private static Wait single_instance = null;
    private static int TIMEOUT = Integer.valueOf(System.getenv("TIMEOUT"));

    private Wait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    public static Wait getInstance()
    {
        if (single_instance == null)
            single_instance = new Wait(driver, 5);

        return single_instance;
    }
}

