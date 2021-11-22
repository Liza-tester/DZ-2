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
        firstNameInput.setValue(this.data.getFirstName());
        return this;
    }

    public RegistrationPage typeLastName() {
        lastNameInput.setValue(this.data.getLastName());
        return this;
    }

    public RegistrationPage typeEmail() {
        emailInput.setValue(this.data.getEmail());
        return this;
    }

    public RegistrationPage typeNumber() {
        numberInput.setValue(this.data.getNumber());
        return this;
    }

    public RegistrationPage selectGender() {
        $(byText(this.data.getGender())).click();
        return this;
    }

    public RegistrationPage typeAddress() {
        addressInput.setValue(this.data.getAddress());
        return this;
    }

    public RegistrationPage selectState() {
        stateList.scrollTo().click();
        $(byText(this.data.getState())).click();
        return this;
    }

    public RegistrationPage selectCity() {
        cityList.scrollTo().click();
        $(byText(this.data.getCity())).click();
        return this;
    }

    public RegistrationPage typeSubjects() {
        subjectsInput.scrollTo();
        for (String subject : this.data.getSubjects())
            subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies() {
        hobbiesSelect.scrollTo();
        for (String hobby : this.data.getHobbies())
            hobbiesSelect.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        pictureUpload.uploadFromClasspath(data.getFileURL());
        return this;
    }

    public RegistrationPage typeDateOfBirth() {
        CalendarComponent calendar = new CalendarComponent(dateOfBirthInput, this.data);
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
        checkResultTableValue("Student Name", this.data.getFirstName() + " " + this.data.getLastName());
        checkResultTableValue("Student Email", this.data.getEmail());
        checkResultTableValue("Gender", this.data.getGender());
        checkResultTableValue("Mobile", this.data.getNumber());

        checkResultTableValue("Date of Birth",
                this.data.getBirthDay() + " " +
                        this.data.getBirthMonth() + "," +
                        this.data.getBirthYear());
        checkResultTableValue("Subjects", String.join(", ", this.data.getSubjects()));
        checkResultTableValue("Hobbies", String.join(", ", this.data.getHobbies()));
        checkResultTableValue("Picture", this.data.getFileURL());
        checkResultTableValue("Address", this.data.getAddress());
        checkResultTableValue("State and City", this.data.getState() + " " + this.data.getCity());
    }
    //________________________________________________________
}