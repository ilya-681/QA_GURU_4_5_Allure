package io.qaguru.ignatovilya;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";

    @Step("Открываем страницу GitHub.com")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(final String repository) {
        $("[name=q]").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Переходим в раздел Issue")
    public void openRepositoryIssues() {
        $(".UnderlineNav-body").$(byText("Issues")).click();
    }

    @Step("Проверяем, что Issue с номером {Issue} существует")
    public void shouldSeeIssueWithNumber(final String number) {
        $(".repository-content ").shouldHave(Condition.text(number));
    }
}
