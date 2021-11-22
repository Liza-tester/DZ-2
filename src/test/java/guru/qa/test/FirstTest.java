package guru.qa.test;

import guru.qa.data.RegistrationData;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends BaseTest {

    @Test
    void firstTest() {

        RegistrationPage registrationPage = new RegistrationPage(new RegistrationData());

        registrationPage.openPage()
                .fillEntireForm()
                .pressSubmit();
        registrationPage.checkResultTable();

        sleep(10000);

    }

}
