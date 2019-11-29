package com.codecool.util;

import com.codecool.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Util {
    WebDriver driver = Driver.getInstance();

    public void initLoginPage(){
        driver.get("https://jira.codecool.codecanvas.hu/login.jsp");
    }

    public void initDashLoginPage(){
        driver.get("https://jira.codecool.codecanvas.hu/secure/Dashboard.jspa");
    }

    public void tearDown(){
        //Driver.resetDriver();
        driver.quit();
    }

    public void mainLogin(String user){
        initLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.successfulLoginWithValidUser(user);
    }
}
