package me.mwi;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import me.mwi.components.AnnotationStepForTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WithAnnotationTest extends TestBase {

    @DisplayName("\"Product card contains Brand's link\" with AnnotationStep Test")
    @Test
    public void testWithAnnotationStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationStepForTest step = new AnnotationStepForTest();
        step.openMainPage(link);
        step.searchBrandsStock(request);
        step.openFirstProductCard();
        step.openProperties();
        step.cardContainsBrand(key, request);
    }

}
