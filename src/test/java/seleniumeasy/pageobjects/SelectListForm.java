package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html")
public class SelectListForm extends SeleniumEasyForm {

    private static final By DAYS_OF_THE_WEEK = By.id("select-demo");

    public String selectedDay() {
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    public void selectDay(String date) {
        $(DAYS_OF_THE_WEEK).selectByValue(date);
    }
}
