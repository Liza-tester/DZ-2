package guru.qa.test;

import guru.qa.data.RegistrationData;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class PositiveTests extends BaseTest {

    @Test
        void allElementsTest() {

        RegistrationPage registrationPage = new RegistrationPage(new RegistrationData());

        registrationPage.openPage()
                .fillEntireForm()
                .pressSubmit();
        registrationPage.checkResultTable();
    }

    @Test
    void essentialElementsTest() {

        RegistrationPage registrationPage = new RegistrationPage(new RegistrationData());

        registrationPage.openPage()
                .typeFirstName()
                .typeLastName()
                .selectGender()
                .typeNumber()
                .pressSubmit();
        registrationPage.checkResultTableValue("Date of Birth", "none");
    }

}
