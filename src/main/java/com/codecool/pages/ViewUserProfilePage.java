package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewUserProfilePage extends BasePage{

    @FindBy(id="up-d-username")
    private WebElement actualUserName;

    public String getActualUserName(){
        return actualUserName.getText();
    }
}
