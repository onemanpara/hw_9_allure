package me.mwi;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;



public class TestBase {

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1920x1080";

    }

    String link = "https://sportpoint.ru";
    String request = "Adidas";
    String key = "Бренд";

}
