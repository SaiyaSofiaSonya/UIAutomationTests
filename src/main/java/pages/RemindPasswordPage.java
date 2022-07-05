package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RemindPasswordPage  extends Page {
    private final String titleXpath = "div[class = \"info-title\"]";

    public SelenideElement pageHeader() {
        return $(titleXpath);
    }
}
