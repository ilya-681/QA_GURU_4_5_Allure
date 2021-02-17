package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchIssueTest {

    private static final String RepositoryName = "eroshenkoam/allure-example";
    private static final String Issue = "Listeners NamedBy";

    @Test
    void simpleSelenideSearch() {

        open("https://github.com/");

        $("[name=q]").setValue(RepositoryName).pressEnter();
        $(byLinkText(RepositoryName)).click();
        $(".UnderlineNav-body").$(byText("Issues")).click();

        $(".repository-content ").shouldHave(Condition.text(Issue));

    }
}
