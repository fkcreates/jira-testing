package com.codecool.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id="login-form-username")
    private WebElement userName;

    @FindBy(id="login-form-password")
    private WebElement password;

    @FindBy(id="login-form-submit")
    private WebElement submitLoginBtn;

    @FindBy(css = ".error")
    private WebElement errorMsg;

    public void successfulLoginWithValidUser(String user){
        String pass = System.getenv("PASSWORD");
        userName.sendKeys(user);
        password.sendKeys(pass);
        submitLoginBtn.click();
    }

    public void loginWithUser(String uName, String pwd){
        userName.sendKeys(uName);
        password.sendKeys(pwd);
        submitLoginBtn.click();
    }

    public void waitForError(){
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
    }

    public String getErrorMsg(){
        return errorMsg.getText();
    }

}
