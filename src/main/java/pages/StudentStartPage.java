package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class StudentStartPage  extends Page {
    private final String burgerButtonXpath =
            "div[class = \"mira-drop-down-container-head-button\"]";
    private final String logoutXpath = "div[class = \"mira-user-info-logout\"]";
    private final String newsHeaderXpath = "div[title = \"Новости\"]";

    public SelenideElement burgerButton() {
        return $(burgerButtonXpath);
    }

    public SelenideElement logoutButton() {
        return $(logoutXpath);
    }

    public SelenideElement newsHeader() {
        return $(newsHeaderXpath);
    }

}
