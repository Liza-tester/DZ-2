package guru.qa.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.properties.OwnerTests;
import guru.qa.util.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1900x1200";

        SelenideLogger.addListener("allure", new AllureSelenide());

        //_______Url with Owner properties______________________________________________
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        String login = OwnerTests.credentials.login();
        String password = OwnerTests.credentials.password();
        String path = format("https://%s:%s@%s", login, password, url);
        //_______________________________________________________________________________


        //_______Selenoid Usage__________________________________________________________
        Configuration.remote = path;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        //_______________________________________________________________________________


    }

    @AfterEach
    public void afterEachAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }

}
