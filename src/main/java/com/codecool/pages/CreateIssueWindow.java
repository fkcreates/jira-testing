package com.codecool.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateIssueWindow extends BasePage {

    @FindBy(id = "project-field")
    private WebElement projectField;

    @FindBy(id = "issuetype-field")
    private WebElement issueField;

    @FindBy(id = "summary")
    private WebElement summary;

    @FindBy(id = "create-issue-submit")
    private WebElement issueSubmitBtn;

    private void fillOutProjectDropdown(){
        projectField.click();
        projectField.sendKeys("three");
        projectField.sendKeys(Keys.TAB);
    }

    private void fillOutIssuetypeField(){
        issueField.click();
        issueField.sendKeys("test");
        issueField.sendKeys(Keys.TAB);
    }

    private void waitTillProjectActive(){
        wait.until(ExpectedConditions.textToBePresentInElementValue(projectField, "ThreeSix (THREESIX)"));
    }

    private void waitTillIssueActive(){
        wait.until(ExpectedConditions.textToBePresentInElementValue(issueField, "Test Data"));
    }

    private void fillOutSummary(){
        summary.sendKeys("test data new");
    }

    private void clickSubmitIssue(){
        issueSubmitBtn.click();
    }

    public void createTestDataIssueInProject36(){
        fillOutProjectDropdown();
        waitTillProjectActive();
        fillOutIssuetypeField();
        waitTillIssueActive();
        fillOutSummary();
        clickSubmitIssue();
    }
}
