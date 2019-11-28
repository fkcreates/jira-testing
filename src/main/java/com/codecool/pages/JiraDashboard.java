package com.codecool.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JiraDashboard extends BasePage {

    @FindBy(id="view_profile")
    private WebElement viewProfile;

    @FindBy(id="header-details-user-fullname")
    private WebElement navBarProfile;

    @FindBy(id="log_out")
    private WebElement logout;

    @FindBy(id = "create_link")
    private WebElement createBtn;

    @FindBy(xpath = "/html/body/div[1]/div/div/a")
    private WebElement issueLink;

    @FindBy(id="browse_link")
    private WebElement projects;

    @FindBy(id="project_view_all_link_lnk")
    private WebElement viewAllProjects;

    @FindBy(xpath="//a[@original-title='Main Testing Project']")
    private WebElement mainTestingProject;

    @FindBy(xpath = "//img[@alt='Main Testing Project']")
    private WebElement mainTestingProjectLogo;

    @FindBy(xpath = "//dd[contains(text(), 'MTP')]")
    private WebElement keyOfMTP;

    @FindBy(xpath = "//a[@original-title='COALA Project']")
    private WebElement coalaTitle;

    @FindBy(xpath = "//a[@original-title='TOUCAN projekt']")
    private WebElement toucanTitle;

    @FindBy(xpath = "//a[@original-title='JETI Project']")
    private WebElement jetiTitle;

    @FindBy(id = "find_link")
    private WebElement issuesBtnOnNavbar;

    @FindBy(id = "issues_new_search_link_lnk")
    private WebElement searchForIssues;

    public void clickUserProfile(){
        navBarProfile.click();
    }

    public void clickProfileDetails() {
        viewProfile.click();
    }

    public void clickLogout(){
        logout.click();
    }

    public void clickCreateIssueBtn() {
        createBtn.click();
    }

    public void clickToViewAllProjects(){
        projects.click();
        viewAllProjects.click();
    }

    public void clickOnMainTestingProject(){
        mainTestingProject.click();
    }

    public void clickOnMTPImage() {
        mainTestingProjectLogo.click();
    }

    public boolean isKeyDisplayed(){
        return keyOfMTP.isDisplayed();
    }

    public boolean isCoalaDisplayed(){
        return coalaTitle.isDisplayed();
    }

    public boolean isToucanDisplayed(){
        return toucanTitle.isDisplayed();
    }

    public boolean isJetiDisplayed(){
        return jetiTitle.isDisplayed();
    }

    public void navigateToProject(String url) {
        driver.get(url);
    }

    private void waitForIssueLink() {
        wait.until(ExpectedConditions.visibilityOf(issueLink));
    }

    private void clickIssueLink () {
        issueLink.click();
    }

    public void navigateToCreatedIssue () {
        waitForIssueLink();
        clickIssueLink();
    }

    private void clickIssuesOnNavbar(){
        issuesBtnOnNavbar.click();
    }

    private void clickSearchForIssues(){
        searchForIssues.click();
    }

    private void waitForSearchIssuePageLoad(){
        wait.until(ExpectedConditions.titleContains("WEAKS"));
    }

    public void navigateToSearchIssues(){
        clickIssuesOnNavbar();
        clickSearchForIssues();
        //waitForSearchIssuePageLoad();
    }
}
