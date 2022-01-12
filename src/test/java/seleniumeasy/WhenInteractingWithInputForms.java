package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.DoubleInputFieldsForm;
import seleniumeasy.pageobjects.SingleInputFieldsForm;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome",uniqueSession = true)
    WebDriver driver;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    SingleInputFieldsForm singleInputFieldsForm;

    @Test
    public void basicForms() {
        singleInputFieldsForm.open();

        singleInputFieldsForm.enterMessage("Hello There");

        singleInputFieldsForm.showMessage();

        assertThat(singleInputFieldsForm.displayMessage()).isEqualTo("Hello There");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    DoubleInputFieldsForm doubleInputFieldsForm;

    @Test
    public void basicFormsWithMultipleFields() {
        doubleInputFieldsForm.open();

        doubleInputFieldsForm.enterFirstNumber("4");

        doubleInputFieldsForm.enterSecondNumber("6");

        doubleInputFieldsForm.displayNumbers();

        assertThat(doubleInputFieldsForm.displayNumber()).isEqualTo("10");
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    @Test
    public void singleCheckbox() {
    }

    @Test
    public void multipleCheckboxes() {
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {
    }

    @Test
    public void multipleRadioButtons() {
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {
    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {
    }
}