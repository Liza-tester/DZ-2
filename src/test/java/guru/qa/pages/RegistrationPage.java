package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.data.RegistrationData;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    //data variables
    private RegistrationData data;

    public RegistrationPage(RegistrationData data) {
        this.data = data;
    }

    // locators & elements
    private static SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            addressInput = $("#currentAddress"),
            stateList = $("#state"),
            cityList = $("#city"),
            subjectsInput = $("#subjectsInput"),
            hobbiesSelect = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            submitButton = $("#submit");


// actions

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName() {
        firstNameInput.setValue(data.getFirstName());
        return this;
    }

    public RegistrationPage typeLastName() {
        lastNameInput.setValue(data.getLastName());
        return this;
    }

    public RegistrationPage typeEmail() {
        emailInput.setValue(data.getEmail());
        return this;
    }

    public RegistrationPage typeNumber() {
        numberInput.setValue(data.getNumber());
        return this;
    }

    public RegistrationPage selectGender() {
        $(byText(data.getGender())).click();
        return this;
    }

    public RegistrationPage typeAddress() {
        addressInput.setValue(data.getAddress());
        return this;
    }

    public RegistrationPage selectState() {
        stateList.scrollTo().click();
        $(byText(data.getState())).click();
        return this;
    }

    public RegistrationPage selectCity() {
        cityList.scrollTo().click();
        $(byText(data.getCity())).click();
        return this;
    }

    public RegistrationPage typeSubjects() {
        subjectsInput.scrollTo();
        for (String subject : data.getSubjects())
            subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies() {
        hobbiesSelect.scrollTo();
        for (String hobby : data.getHobbies())
            hobbiesSelect.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        pictureUpload.uploadFromClasspath(data.getFileURL());
        return this;
    }

    public RegistrationPage typeDateOfBirth() {
        CalendarComponent calendar = new CalendarComponent(dateOfBirthInput, data);
        calendar.selectDate();
        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.scrollTo().click();
        return this;
    }

    //Заполнение всех доступных на форме полей____________
    public RegistrationPage fillEntireForm() {
        this.typeFirstName()
                .typeLastName()
                .typeEmail()
                .selectGender()
                .typeNumber()
                .typeDateOfBirth()
                .typeSubjects()
                .selectHobbies()
                .uploadPicture()
                .typeAddress()
                .selectState()
                .selectCity();
        return this;
    }
    //_____________________________________________________

    private void checkResultTableValue(String key, String value) {
        $x("//td[text()='" + key + "']/following-sibling::*").shouldHave(exactText(value));
    }

    //Проверка результирующей таблицы______________________
    public void checkResultTable() {
        checkResultTableValue("Student Name", data.getFirstName() + " " + data.getLastName());
        checkResultTableValue("Student Email", data.getEmail());
        checkResultTableValue("Gender", data.getGender());
        checkResultTableValue("Mobile", data.getNumber());

        checkResultTableValue("Date of Birth",
                data.getBirthDay() + " " +
                        data.getBirthMonth() + "," +
                        data.getBirthYear());
        checkResultTableValue("Subjects", String.join(", ", data.getSubjects()));
        checkResultTableValue("Hobbies", String.join(", ", data.getHobbies()));
        checkResultTableValue("Picture", data.getFileURL());
        checkResultTableValue("Address", data.getAddress());
        checkResultTableValue("State and City", data.getState() + " " + data.getCity());
    }
    //________________________________________________________
}