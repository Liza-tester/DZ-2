package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.data.RegistrationData;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private String year, month, day;
    private SelenideElement locator;

    public CalendarComponent(SelenideElement locator, RegistrationData data) {
        this.locator = locator;
        year = data.getBirthYear();
        month = data.getBirthMonth();
        day = data.getBirthDay();
    }

    public void selectDate() {
        locator.scrollTo().click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();
    }


}