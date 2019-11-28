package com.codecool.pages;

import com.codecool.util.Driver;
import com.codecool.util.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(){
        driver = Driver.getInstance();
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
