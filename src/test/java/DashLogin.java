import com.codecool.pages.DashLoginPage;
import com.codecool.pages.JiraDashboard;
import com.codecool.pages.ViewUserProfilePage;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class DashLogin {
    private Util util = new Util();
    private DashLoginPage dashLogin;
    private JiraDashboard jiraMain;
    private ViewUserProfilePage viewUserProfilePage;

    @BeforeEach
    void setup(){
        util.initDashLoginPage();
        dashLogin = new DashLoginPage();
        jiraMain = new JiraDashboard();
        viewUserProfilePage = new ViewUserProfilePage();
    }

    @AfterEach
    void tearDown(){
        util.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testSuccessfulLogin(String user){
        dashLogin.successfulLoginWithValidUser(user);
        jiraMain.clickUserProfile();
        jiraMain.clickProfileDetails();
        Assertions.assertEquals(user, viewUserProfilePage.getActualUserName());
    }

    @Test
    void testIncorrectCredentials(){
        dashLogin.loginWithParameters("user3", "test");
        dashLogin.waitForError();
        Assertions.assertTrue(dashLogin.getErrorField().isDisplayed());
    }

    @Test
    void testEmptyCredentials(){
        dashLogin.loginWithParameters("","");
        dashLogin.waitForError();
        Assertions.assertTrue(dashLogin.getErrorField().isDisplayed());
    }

}
