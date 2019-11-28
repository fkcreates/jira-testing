import com.codecool.pages.IssuePage;
import com.codecool.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class EditIssue {
    private Util util = new Util();
    private IssuePage issuePage;
    private String THREESIXPROJECTURL = "https://jira.codecool.codecanvas.hu/browse/THREESIX-46";
    private String BASE_URL = System.getenv("BASE_URL");
    private String firstEdit = "Test Task 01 edited";
    private String secondEdit = "Test Task 01";

    @BeforeEach
    void setup(){
        issuePage = new IssuePage();
    }

    @AfterEach
    void tearDown() {
        util.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_list.csv")
    void testSuccessfulIssueEditing(String username){
        util.mainLogin(username);
        issuePage.navigateToIssuePageWithUrl(THREESIXPROJECTURL);
        issuePage.editOfIssueInThreeSix46(firstEdit);
        String editedSummary = issuePage.findEditedSummary();

        Assertions.assertEquals(firstEdit, editedSummary);

        issuePage.editOfIssueInThreeSix46(secondEdit);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "username_and_projectlist.csv")
    void testEditAvailabilityInIssues(String username, String issue){
        util.mainLogin(username);
        issuePage.navigateToIssuePageWithUrl(BASE_URL + "browse/" + issue);
        Assertions.assertTrue(issuePage.isEditButtonDisplayed());
    }
}
