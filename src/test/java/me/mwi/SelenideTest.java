package me.mwi;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest extends TestBase {

    @DisplayName("\"Product card contains Brand's link\" simple Selenide Test")
    @Test
    public void selenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(link);
        $("#title-search-input").setValue(request).pressEnter();
        $(".products-product-images:not(tech)").click();
        $x("//div[@class='accord__open product-data__accord__open']" +
                "[contains(text(), 'Характеристики')]").click();
        $x("//table//span[contains(text(),'" + key + "')]").shouldHave(text(key));
        $x("//table//a[contains(text(), '" + request + "')]").shouldHave(text(request));
    }
}
