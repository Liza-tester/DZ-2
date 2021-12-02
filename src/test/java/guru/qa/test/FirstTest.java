package guru.qa.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.data.RegistrationData;
import guru.qa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends BaseTest {

    @Test
    void firstTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        RegistrationPage registrationPage = new RegistrationPage(new RegistrationData());

        registrationPage.openPage()
                .fillEntireForm()
                .pressSubmit();
        registrationPage.checkResultTable();

        sleep(10000);

    }

}
