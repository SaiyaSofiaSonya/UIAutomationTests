package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RemindPasswordPage {

    public SelenideElement pageHeader() {
        return $("div[class = \"info-title\"]");
    }
}
