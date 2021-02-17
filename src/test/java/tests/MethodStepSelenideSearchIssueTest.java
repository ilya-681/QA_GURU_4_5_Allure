package tests;

import io.qaguru.ignatovilya.BaseSteps;
import org.junit.jupiter.api.Test;

public class MethodStepSelenideSearchIssueTest {

    final BaseSteps steps = new BaseSteps();

    private static final String RepositoryName = "eroshenkoam/allure-example";
    private static final String Issue = "Listeners NamedBy";

    @Test
    void methodSelenideSearchIssue() {

        steps.openMainPage();
        steps.searchForRepository(RepositoryName);
        steps.goToRepositoryFromSearch(RepositoryName);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(Issue);

    }
}
