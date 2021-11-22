package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.data.RegistrationData;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private String year, month, day;
    private SelenideElement locator;

    public CalendarComponent(SelenideElement locator, RegistrationData data) {
        this.locator = locator;
        this.year = data.getBirthYear();
        this.month = data.getBirthMonth();
        this.day = data.getBirthDay();
    }

    public void selectDate() {
        this.locator.scrollTo().click();
        $(".react-datepicker__year-select").selectOption(this.year);
        $(".react-datepicker__month-select").selectOption(this.month);
        $(".react-datepicker__day.react-datepicker__day--0" + this.day).click();
    }


}