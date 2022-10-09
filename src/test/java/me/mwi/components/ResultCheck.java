package me.mwi.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class ResultCheck {

    public ResultCheck resultCheck(String key, String request) {
        $x("//table//span[contains(text(),'" + key + "')]").shouldHave(text(key));
        $x("//table//a[contains(text(), '" + request + "')]").shouldHave(text(request));

        return this;
    }
}