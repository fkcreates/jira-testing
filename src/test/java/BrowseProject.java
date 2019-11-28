import com.codecool.pages.JiraDashboard;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class BrowseProject {
    private Util util = new Util();
    private JiraDashboard jiraDashboard;

    @BeforeEach
    void setup(){
        jiraDashboard = new JiraDashboard();
    }

    @AfterEach
    void tearDown(){
        util.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testBrowsingMainTestingProject(String username){
        util.mainLogin(username);
        jiraDashboard.clickToViewAllProjects();
        jiraDashboard.clickOnMainTestingProject();
        jiraDashboard.clickOnMTPImage();

        Assertions.assertTrue(jiraDashboard.isKeyDisplayed());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testCoalaProject(String username){
        util.mainLogin(username);
        jiraDashboard.clickToViewAllProjects();

        Assertions.assertTrue(jiraDashboard.isCoalaDisplayed());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testToucanProject(String username){
        util.mainLogin(username);
        jiraDashboard.clickToViewAllProjects();

        Assertions.assertTrue(jiraDashboard.isToucanDisplayed());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testJetiProject(String username){
        util.mainLogin(username);
        jiraDashboard.clickToViewAllProjects();

        Assertions.assertTrue(jiraDashboard.isJetiDisplayed());
    }
}
