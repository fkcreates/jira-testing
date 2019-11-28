import com.codecool.pages.CreateIssueWindow;
import com.codecool.pages.IssuePage;
import com.codecool.pages.JiraDashboard;
import com.codecool.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CreateIssue {
    private Util util= new Util();
    private JiraDashboard jiraDashboard;
    private CreateIssueWindow createIssueWindow;
    private IssuePage issuePage;

    @BeforeEach
    void setup(){
        jiraDashboard = new JiraDashboard();
        createIssueWindow = new CreateIssueWindow();
        issuePage = new IssuePage();
    }

    @AfterEach
    void tearDown(){
        util.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testCreateIssue(String username){
        util.mainLogin(username);
        jiraDashboard.clickCreateIssueBtn();
        createIssueWindow.createTestDataIssueInProject36();
        jiraDashboard.navigateToCreatedIssue();
        issuePage.deleteNewlyCreatedIssueInProject36();
    }
}
