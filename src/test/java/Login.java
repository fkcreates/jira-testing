import com.codecool.pages.JiraDashboard;
import com.codecool.pages.LoginPage;
import com.codecool.pages.ViewUserProfilePage;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class Login {
    private Util util = new Util();
    private LoginPage loginPage;
    private JiraDashboard jiraMain;
    private ViewUserProfilePage viewUserProfilePage;
    private static final String EXPECTED_ERROR_MSG = "Sorry, your username and password are incorrect - please try again.";

    @BeforeEach
    void setup(){
        util.initLoginPage();
        loginPage = new LoginPage();
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
        loginPage.successfulLoginWithValidUser(user);
        jiraMain.clickUserProfile();
        jiraMain.clickProfileDetails();
        Assertions.assertEquals(user, viewUserProfilePage.getActualUserName());
    }

    @Test
    void testIncorrectCredentials(){
        loginPage.loginWithUser("user3", "test");
        loginPage.waitForError();
        Assertions.assertEquals(EXPECTED_ERROR_MSG, loginPage.getErrorMsg());
    }

    @Test
    void testEmptyCredentials(){
        loginPage.loginWithUser("","");
        loginPage.waitForError();
        Assertions.assertEquals(EXPECTED_ERROR_MSG, loginPage.getErrorMsg());
    }
}
