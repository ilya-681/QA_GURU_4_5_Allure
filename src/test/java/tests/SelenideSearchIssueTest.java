package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearchIssueTest {

    private static final String REPOSITORY_NAME = "eroshenkoam/allure-example";
    private static final String ISSUE = "Listeners NamedBy";

    @Test
    void simpleSelenideSearch() {

        open("https://github.com/");

        $("[name=q]").setValue(REPOSITORY_NAME).pressEnter();
        $(byLinkText(REPOSITORY_NAME)).click();
        $(".UnderlineNav-body").$(byText("Issues")).click();

        $(".repository-content ").shouldHave(Condition.text(ISSUE));

    }
}
