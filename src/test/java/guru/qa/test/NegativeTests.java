package guru.qa.test;

import guru.qa.data.RegistrationData;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class NegativeTests extends BaseTest{

    @Test
    void FirstNameElementTest() {

        RegistrationPage registrationPage = new RegistrationPage(new RegistrationData());

        registrationPage.openPage()
                .typeFirstName()
                .pressSubmit()
                .checkFirstNameElementIsVisible();
    }

}
