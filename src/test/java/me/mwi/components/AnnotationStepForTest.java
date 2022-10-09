package me.mwi.components;

import io.qameta.allure.Step;
import me.mwi.SearchWithLambdaStepsTest;

import static com.codeborne.selenide.Selenide.*;

public class AnnotationStepForTest extends SearchWithLambdaStepsTest {

    private ResultCheck resultCheck = new ResultCheck();

    @Step("Открываем главную страницу")
    public void openMainPage(String link) {
        open(link);
    }

    @Step("Ищем товары бренда ")
    public void searchBrandsStock(String request) {
        $("#title-search-input").setValue(request).pressEnter();
    }

    @Step("Переходим в первую карточку товара")
    public void openFirstProductCard() {
        $(".products-product-images:not(tech)").click();
    }

    @Step("Открываем вкладку \"Характеристики\"")
    public void openProperties() {
        $x("//div[@class='accord__open product-data__accord__open']" +
                "[contains(text(), 'Характеристики')]").click();
    }

    @Step("Проверяем, что свойство \"Бренд\" равно искомому запросу")
    public void cardContainsBrand(String key, String request) {
        resultCheck.resultCheck(key, request);
    }
}
