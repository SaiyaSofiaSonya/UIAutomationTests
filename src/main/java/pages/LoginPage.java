package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
//    private final String loginFieldSCCSelector = "input[name= \"user\"]";
//    private final String passwordFieldCSSSelector = "input[name= \"password\"]";
//    private final String enterButtonCSSSelector = "button[id= \"button_submit_login_form\"]";
//    private final String forgetPasswordCSSSelector = "a[class = \"mira-default-login-page-link\"]";
//    private final String showPasswordCssSelector = "button[id= \"show_password\"]";

    public static LoginPage open() {
        Selenide.open("https://lmslite47vr.demo.mirapolis.ru/mira");
        return new LoginPage();
    }

    public void loginAs(String login, String password) {
        click("input[name= \"user\"]");
        setValue("input[name= \"user\"]", login);
        click("input[name= \"password\"]");
        setValue("input[name= \"password\"]", password);
        click("button[id= \"button_submit_login_form\"]");
    }

    public void loginInUpperCaseAs(String login, String password) {
        click("input[name= \"user\"]");
        setValue("input[name= \"user\"]", login.toUpperCase());
        click("input[name= \"password\"]");
        setValue("input[name= \"password\"]", password);
        click("button[id= \"button_submit_login_form\"]");
    }

    public void loginWithEmptyFieldsAs(String value, String field) {
      if (field.contains("login")) {
          click("input[name= \"user\"]");
          setValue("input[name= \"user\"]", value);
        } else if(field.contains("password")) {
          click("input[name= \"password\"]");
          setValue("input[name= \"password\"]", value);
      }
        $("button[id= \"button_submit_login_form\"]").click();
    }

    public void click(String cssSelector) {
        $(cssSelector).click();
    }

    public void setValue(String cssSelector, String value) {
        $(cssSelector).setValue(value);
    }

    public RemindPasswordPage goToRemindPasswordPage() {
        return new RemindPasswordPage();
    }

    public StudentStartPage goToStudentStartPage() {
        return new StudentStartPage();
    }

    public void clickOnForgotPasswordLink() {
        $("a[class = \"mira-default-login-page-link\"]").click();
    }

    public void clickOnShowPasswordButton() {
        $("button[id= \"show_password\"]").click();
    }

    public SelenideElement inputToPasswordField() {
       return  $("input[name= \"password\"]");
    }

    public SelenideElement loginField() {
        return  $("input[name= \"user\"]");
    }
}
