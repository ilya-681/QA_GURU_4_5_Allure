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

    private static final String BaseURL = "https://github.com/";
    private static final String RepositoryName = "eroshenkoam/allure-example";
    private static final String Issue = "Listeners NamedBy";
    private static final String Issues = "Issues";

    @Test
    @Owner("IgnatovIlya")
    @Link(name = BaseURL, value = BaseURL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Severity(SeverityLevel.NORMAL)

    @Feature("Issues")
    @Story("Поиск в существующем репозитории")
    @DisplayName("Поиск Issue по номеру в репозитории")
    void stepSelenideSearch() {

        parameter("Repository", RepositoryName);
        parameter("Issue", Issue);

        step("Открываем страницу GitHub.com", () ->
                open(BaseURL));

        step("Ищем репозиторий " + RepositoryName, () -> {
            $("[name=q]").setValue(RepositoryName).pressEnter();
        });

        step("Переходим в репозиторий " + RepositoryName, () ->
                $(byLinkText(RepositoryName)).click());

        step("Переходим в раздел " + Issues, () ->
                $(".UnderlineNav-body").$(byText(Issues)).click());

        step("Проверяем, что Issue с номером " + Issue + " существует", () -> {
            $(".repository-content ").shouldHave(Condition.text(Issue));
        });

    }
}
