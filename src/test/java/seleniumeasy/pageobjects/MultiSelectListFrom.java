package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class MultiSelectListFrom extends SeleniumEasyForm {

    private static final By STATE = By.id("multi-select");

    public List<String> selectedStates() {
        return $(STATE).getSelectedValues();
    }

    public void selectState(String... states) {
        Arrays.stream(states).forEach(
                state -> $(STATE).selectByValue(state)
        );
    }
}
