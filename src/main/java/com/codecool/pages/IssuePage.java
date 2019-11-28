package com.codecool.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePage extends BasePage {

    @FindBy(id = "edit-issue")
    private WebElement editButton;

    @FindBy(id = "summary-val")
    private WebElement summaryOfIssue;

    @FindBy(css = ".dropdown-text")
    private WebElement taskMenuDropdown;

    @FindBy(linkText = "Delete")
    private WebElement deleteThisTask;

    @FindBy(id = "delete-issue-dialog")
    private WebElement deleteConfirmationWindow;

    @FindBy(id = "delete-issue-submit")
    private WebElement deleteConfirmationBtn;

    @FindBy(id = "edit-issue-submit")
    private WebElement editSubmitButton;

    @FindBy(xpath = "//input[@id='summary']")
    private WebElement summaryInputField;

    @FindBy(xpath = "//*[@id='aui-flag-container']/div[@class='aui-flag']/div[contains(text(), 'has been updated')]")
    private WebElement alertWindow;

    @FindBy(xpath = "//*[@id=\"issue-content\"]/div/div/h1")
    private WebElement headerTitle;

    public boolean isEditButtonDisplayed() {
        return editButton.isDisplayed();
    }

    public void waitForSummaryToAppear(){
        wait.until(ExpectedConditions.visibilityOf(summaryOfIssue));
    }

    private void waitForPageLoad(){
        wait.until(ExpectedConditions.titleContains("THREESIX"));
    }

    private void clickOnDropdownMenu(){
        taskMenuDropdown.click();
    }

    private void clickDeleteInDropdownMenu(){
        deleteThisTask.click();
    }

    private void waitForDeletePopupWindow(){
        wait.until(ExpectedConditions.visibilityOf(deleteConfirmationWindow));
    }

    private void clickPopupWindowDeleteBtn(){
        deleteConfirmationBtn.click();
    }

    public void deleteNewlyCreatedIssueInProject36(){
        waitForPageLoad();
        clickOnDropdownMenu();
        clickDeleteInDropdownMenu();
        waitForDeletePopupWindow();
        clickPopupWindowDeleteBtn();
    }

    public void waitForSummaryInputField(){
        wait.until(ExpectedConditions.visibilityOf(summaryInputField));
    }

    public void clickOnEditButton(){
        editButton.click();
    }

    public void editSummaryField(String summaryMessage){
        summaryInputField.sendKeys(summaryMessage);
    }

    public void clickOnEditSubmit(){
        editSubmitButton.click();
    }

    public String findEditedSummary(){
        return driver.findElement(By.id("summary-val")).getText();
    }

    public void waitForAlertAboutEdit(){
        wait.until(ExpectedConditions.visibilityOf(alertWindow));
    }

    public void editOfIssueInThreeSix46(String editMessage){
        clickOnEditButton();
        waitForSummaryInputField();
        editSummaryField(editMessage);
        clickOnEditSubmit();
        waitForAlertAboutEdit();
    }

    public void navigateToIssuePageWithUrl(String URL){
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOf(summaryOfIssue));
    }

    public void navigateToIssue(String baseurl, String issuePage){
        driver.navigate().to(baseurl + "browse/" + issuePage);
    }

    public void navigateToNonExistingProject(){
        driver.get("https://jira.codecool.codecanvas.hu/browse/THREESIX-666666");
    }

    public String getHeader(){
        return headerTitle.getText();
    }

    public boolean checkIfTitleContainsCorrectIssueName(String issuePage){
        return driver.getTitle().contains(issuePage);
    }
}
