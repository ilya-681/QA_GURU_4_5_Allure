package tests;


import io.qaguru.ignatovilya.BaseSteps;
import org.junit.jupiter.api.Test;

public class MethodStepSelenideSearchIssueTest {

    final BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY_NAME = "eroshenkoam/allure-example";
    private static final String ISSUE = "Listeners NamedBy";

    @Test
    void methodSelenideSearchIssue() {

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY_NAME);
        steps.goToRepositoryFromSearch(REPOSITORY_NAME);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
