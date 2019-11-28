import com.codecool.pages.JiraDashboard;
import com.codecool.pages.LogoutPage;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class Logout {
    private Util util = new Util();
    private JiraDashboard jiraDashboard;
    private LogoutPage logoutPage;

    @BeforeEach
    void setup(){
        jiraDashboard = new JiraDashboard();
        logoutPage = new LogoutPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testLogout(String username){
        util.mainLogin(username);
        jiraDashboard.clickUserProfile();
        jiraDashboard.clickLogout();
        logoutPage.waitForLoginLink();
        Assertions.assertTrue(logoutPage.getLoginLink().isDisplayed());
    }



    @AfterEach
    void tearDown(){
        util.tearDown();
    }
}
