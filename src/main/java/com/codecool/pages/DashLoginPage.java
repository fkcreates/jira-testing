package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashLoginPage extends BasePage {

    @FindBy(id="login-form-username")
    private WebElement userField;

    @FindBy(id="login-form-password")
    private WebElement passwordField;

    @FindBy(id="login")
    private WebElement submitLoginButton;

    @FindBy(id = "usernameerror")
    private WebElement errorField;

    public WebElement getErrorField() {
        return errorField;
    }

    public void successfulLoginWithValidUser(String user){
        String pass = System.getenv("PASSWORD");
        userField.sendKeys(user);
        passwordField.sendKeys(pass);
        submitLoginButton.click();
    }

    public void loginWithParameters(String userName, String password){
        userField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    public void waitForError(){
        wait.until(ExpectedConditions.visibilityOf(errorField));
    }
}
