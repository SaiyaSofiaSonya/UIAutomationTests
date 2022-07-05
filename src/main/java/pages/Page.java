package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.$;

public class Page {
    private static String propertyFilePath;
    private String host;
    private String browser;
    private String browserSize;

    public LoginPage open() {
        propertyFilePath = System.getProperty("user.dir")
                    + "\\src\\main\\resources\\config.properties";

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
        host = prop.getProperty("host");
        browserSize = prop.getProperty("browserSize");
        // Configuration.browser =
        Configuration.browserSize = prop.getProperty("resolution");
        Selenide.open(host+ "/mira");
        return new LoginPage();
    }

    public void click(String xpath) {
        $(xpath).click();
    }

    public void setValue(String xpath, String value) {
        $(xpath).setValue(value);
    }
}
