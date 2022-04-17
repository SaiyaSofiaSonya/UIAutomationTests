package ru.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RemindPasswordPage;
import pages.StudentStartPage;
import static com.codeborne.selenide.Selenide.confirm;


public class LoginTests extends BaseUITests {

    @Test
    public void userCanLoginWithValidCredentialsTest() {
         LoginPage loginPage = LoginPage.open();
         loginPage.loginAs("fominaelena", "1P73BP4Z");
         StudentStartPage studentStartPage = loginPage.goToStudentStartPage();
         studentStartPage.newsHeader().should(Condition.text("Новости"));
    }

    @Test
    public void userCanLoginWithValidLoginInUpperCase() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginInUpperCaseAs("fominaelena", "1P73BP4Z");
        StudentStartPage studentStartPage = loginPage.goToStudentStartPage();
        studentStartPage.newsHeader().should(Condition.text("Новости"));
    }

    @Test
    public void userCanNotLoginWithInvalidCredentialsTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginAs("fominaelena1", "11P73BP4Z");
        confirm("Неверные данные для авторизации");
        }


    @Test
    public void userCanLoginWithValidLoginAndInvalidPasswordsTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginAs("fominaelena", "11P73BP4Z");
        confirm("Неверные данные для авторизации");
    }

    @Test
    public void userCanLoginWithInvalidLoginAndValidPasswordTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginAs("fominaelena", "1P73BP4erZ");
        confirm("Неверные данные для авторизации");
    }

    @Test
    public void userCanNotLoginWithEmptyLoginAndPasswordTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginWithEmptyFieldsAs(null, "both");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void userCanNotLoginWithEmptyLoginTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginWithEmptyFieldsAs("1P73BP4erZ", "password");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void userCanNotLoginWithEmptyPasswordTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginWithEmptyFieldsAs("fominaelena", "login");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void goToRemindPasswordPageTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.clickOnForgotPasswordLink();
        RemindPasswordPage remindPasswordPage = loginPage.goToRemindPasswordPage();
        remindPasswordPage.pageHeader().should(Condition.text("Восстановление пароля"));
    }

    @Test
    public void showPasswordSwitchOnTest() {
        LoginPage loginPage = LoginPage.open();
        loginPage.clickOnShowPasswordButton();
        loginPage.inputToPasswordField().should(Condition.type("text"));
    }

    @Test
    public void passwordPlaceholderHasName() {
        LoginPage loginPage = LoginPage.open();
        loginPage.inputToPasswordField().should(Condition
                .attributeMatching("Placeholder", "Введите ваш пароль"));
    }

    @Test
    public void loginPlaceholderHasName() {
        LoginPage loginPage = LoginPage.open();
        loginPage.loginField().should(Condition
                .attributeMatching("Placeholder", "Введите ваш логин"));
    }

}
