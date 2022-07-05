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
         LoginPage loginPage = new LoginPage();
         loginPage
                 .open()
                 .loginAs("fominaelena", "1P73BP4Z");
         StudentStartPage studentStartPage = loginPage.goToStudentStartPage();
         studentStartPage.newsHeader().should(Condition.text("Новости"));
    }

    @Test
    public void userCanLoginWithValidLoginInUpperCase() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginInUpperCaseAs("fominaelena", "1P73BP4Z");
        StudentStartPage studentStartPage = loginPage.goToStudentStartPage();
        studentStartPage.newsHeader().should(Condition.text("Новости"));
    }

    @Test
    public void userCanNotLoginWithInvalidCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginAs("fominaelena1", "11P73BP4Z");
        confirm("Неверные данные для авторизации");
        }


    @Test
    public void userCanLoginWithValidLoginAndInvalidPasswordsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginAs("fominaelena", "11P73BP4Z");
        confirm("Неверные данные для авторизации");
    }

    @Test
    public void userCanLoginWithInvalidLoginAndValidPasswordTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginAs("fominaelena", "1P73BP4erZ");
        confirm("Неверные данные для авторизации");
    }

    @Test
    public void userCanNotLoginWithEmptyLoginAndPasswordTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginWithEmptyFieldsAs(null, "both");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void userCanNotLoginWithEmptyLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginWithEmptyFieldsAs("1P73BP4erZ", "password");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void userCanNotLoginWithEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginWithEmptyFieldsAs("fominaelena", "login");
        confirm("Неверные данные для авторизации.");
    }

    @Test
    public void goToRemindPasswordPageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .clickOnForgotPasswordLink();
        RemindPasswordPage remindPasswordPage = loginPage.goToRemindPasswordPage();
        remindPasswordPage.pageHeader().should(Condition.text("Восстановление пароля"));
    }

    @Test
    public void showPasswordSwitchOnTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .clickOnShowPasswordButton();
        loginPage.inputToPasswordField().should(Condition.type("text"));
    }

    @Test
    public void passwordPlaceholderHasName() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .inputToPasswordField().should(Condition
                .attributeMatching("Placeholder", "Введите ваш пароль"));
    }

    @Test
    public void loginPlaceholderHasName() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .loginField().should(Condition
                .attributeMatching("Placeholder", "Введите ваш логин"));
    }

}
