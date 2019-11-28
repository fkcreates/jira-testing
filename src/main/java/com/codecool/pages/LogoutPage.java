package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage{

    @FindBy(css = ".login-link")
    private WebElement loginLink;

    public void waitForLoginLink(){
        wait.until(ExpectedConditions.visibilityOf(loginLink));
    }

    public WebElement getLoginLink() {
        return loginLink;
    }
}
