package ru.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.Selenide;
public class BaseUITests {

    @AfterEach
    public void clear() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
