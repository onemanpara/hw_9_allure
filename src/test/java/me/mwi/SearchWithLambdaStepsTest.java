package me.mwi;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SearchWithLambdaStepsTest extends TestBase {

    @DisplayName("\"Product card contains Brand's link\" with Lambda Steps Test")
    @Test
    public void searchTestWithLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу " + link, () -> {
            open(link);
        });
        step("Ищем товары бренда " + request, () ->{
            $("#title-search-input").setValue(request).pressEnter();
        });
        step("Переходим в первую карточку товара", () -> {
            $(".products-product-images:not(tech)").click();
        });
        step("Открываем вкладку \"Характеристики\"", () -> {
            $x("//div[@class='accord__open product-data__accord__open']" +
                    "[contains(text(), 'Характеристики')]").click();
        });
        step("Проверяем, что свойство \"Бренд\" равно искомому запросу " + request, () -> {
            $x("//table//span[contains(text(),'" + key + "')]").shouldHave(text(key));
            $x("//table//a[contains(text(), '" + request + "')]").shouldHave(text(request));
        });
    }
}
