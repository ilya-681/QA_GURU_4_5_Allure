package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class LambdaStepsSelenideSearchIssueTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY_NAME = "eroshenkoam/allure-example";
    private static final String ISSUE = "Listeners NamedBy";
    private static final String ISSUES = "Issues";

    @Test
    @Owner("IgnatovIlya")
    @Link(name = BASE_URL, value = BASE_URL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Severity(SeverityLevel.NORMAL)

    @Feature("Issues")
    @Story("Поиск в существующем репозитории")
    @DisplayName("Поиск Issue по номеру в репозитории")
    void stepSelenideSearch() {

        parameter("Repository", REPOSITORY_NAME);
        parameter("Issue", ISSUE);

        step("Открываем страницу GitHub.com", () -> open(BASE_URL));
        step("Ищем репозиторий " + REPOSITORY_NAME, () -> $("[name=q]").setValue(REPOSITORY_NAME).pressEnter());
        step("Переходим в репозиторий " + REPOSITORY_NAME, () -> $(byLinkText(REPOSITORY_NAME)).click());
        step("Переходим в раздел " + ISSUES, () -> $(".UnderlineNav-body").$(byText(ISSUES)).click());
        step("Проверяем, что Issue с номером " + ISSUE + " существует", () -> $(".repository-content ").shouldHave(Condition.text(ISSUE)));

    }
}
