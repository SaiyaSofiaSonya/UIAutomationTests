package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

    public class LoginPage extends Page {
    private final String loginXpath = "input[name= \"user\"]";
    private final String passwordXpath = "input[name= \"password\"]";
    private final String submitXpath = "button[id= \"button_submit_login_form\"]";
    private final String forgetPasswordXpath = "a[class = \"mira-default-login-page-link\"]";
    private final String showPasswordXpath =  "button[id= \"show_password\"]";


    public void loginAs(String login, String password) {
        System.out.println(loginXpath);
        click(loginXpath);
        setValue(loginXpath, login);
        click(passwordXpath);
        setValue(passwordXpath, password);
        click(submitXpath);
    }

    public void loginInUpperCaseAs(String login, String password) {
        click(loginXpath);
        setValue(loginXpath, login.toUpperCase());
        click(passwordXpath);
        setValue(passwordXpath, password);
        click(submitXpath);
    }

    public void loginWithEmptyFieldsAs(String value, String field) {
      if (field.contains("login")) {
          click(loginXpath);
          setValue(loginXpath, value);
        } else if (field.contains("password")) {
          click(passwordXpath);
          setValue(passwordXpath, value);
      }
        $(submitXpath).click();
    }

    public RemindPasswordPage goToRemindPasswordPage() {
        return new RemindPasswordPage();
    }

    public StudentStartPage goToStudentStartPage() {
        return new StudentStartPage();
    }

    public void clickOnForgotPasswordLink() {
        $(forgetPasswordXpath).click();
    }

    public void clickOnShowPasswordButton() {
        $(showPasswordXpath).click();
    }

    public SelenideElement inputToPasswordField() {
       return  $(passwordXpath);
    }

    public SelenideElement loginField() {
        return  $(loginXpath);
    }
}
