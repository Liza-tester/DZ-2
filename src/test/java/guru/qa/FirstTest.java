package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void firstTest() throws InterruptedException {

        open("https://demoqa.com/automation-practice-form");
        // Заполнение формы

        $("#firstName").setValue("Ivanessa");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov123@mail.ru");
        $(byText("Other")).click();
        $("#userNumber").setValue("8005553535");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day.react-datepicker__day--006").click();

        $("#subjectsInput").setValue("Ch").pressEnter()
                .setValue("E").pressEnter();

        $(byText("Sports")).scrollTo().click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/picture.jpg"));

        $("#currentAddress").setValue("Toropigina 7/4, 676");

        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Merrut")).click();
        $("#submit").click();

        // Проверка значений
        checkValue("Student Name", "Ivanessa Ivanov");
        checkValue("Student Email", "Ivanov123@mail.ru");
        checkValue("Gender", "Other");
        checkValue("Mobile", "8005553535");
        checkValue("Date of Birth","06 July,1995");
        checkValue("Subjects", "Chemistry, English");
        checkValue("Hobbies", "Sports, Music");
        checkValue("Picture", "picture.jpg");
        checkValue("Address", "Toropigina 7/4, 676");
        checkValue("State and City", "Uttar Pradesh Merrut");



    }

    static void checkValue(String key, String value){
        $x("//td[text()='"+ key + "']/following-sibling::*").shouldHave(exactText(value));
    }
}
