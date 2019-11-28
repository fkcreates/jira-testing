import com.codecool.pages.IssuePage;
import com.codecool.pages.JiraDashboard;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class BrowseIssue {
    private Util util= new Util();
    private JiraDashboard jiraDashboard;
    private IssuePage projectPage;
    private String error = "You can't view this issue";
    private String BASE_URL = System.getenv("BASE_URL");


    @BeforeEach
    void setup(){
        jiraDashboard = new JiraDashboard();
        projectPage = new IssuePage();
    }

    @AfterEach
    void tearDown(){
        util.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testBrowseIssue(String username){
        util.mainLogin(username);
        jiraDashboard.navigateToSearchIssues();
        projectPage.navigateToIssue(BASE_URL,"THREESIX-66");
        projectPage.navigateToNonExistingProject();
        Assertions.assertEquals(error, projectPage.getHeader());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_and_projectlist.csv")
    void testProjectBrowseIssue(String username, String issuePage) {
        util.mainLogin(username);
        projectPage.navigateToIssue(BASE_URL, issuePage);
        Assertions.assertTrue(projectPage.checkIfTitleContainsCorrectIssueName(issuePage));
    }
}
