package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class StudentStartPage {

    public SelenideElement burgerButton() {

        return $("div[class = \"mira-drop-down-container-head-button\"]");
    }

    public SelenideElement logoutButton() {

        return $("div[class = \"mira-user-info-logout\"]");
    }

    public SelenideElement newsHeader() {

        return $("div[title = \"Новости\"]");
    }

}
