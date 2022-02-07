package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.action.FormPage;
import seleniumeasy.action.NavigateAction;
import seleniumeasy.pageobjects.CheckboxForm;
import seleniumeasy.pageobjects.DoubleInputFieldsForm;
import seleniumeasy.pageobjects.HoverAction;
import seleniumeasy.pageobjects.MultiSelectListFrom;
import seleniumeasy.pageobjects.MultipleRadioButtonsForm;
import seleniumeasy.pageobjects.RadioButtonsForm;
import seleniumeasy.pageobjects.SelectListForm;
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
    @Steps
    NavigateAction navigate;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    SingleInputFieldsForm singleInputFieldsForm;

    @Test
    public void basicForms() {
        navigate.to(FormPage.SingleInputFieldsForm);

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
        navigate.to(FormPage.DoubleInputFieldsForm);

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

    CheckboxForm checkboxForm;

    @Test
    public void singleCheckbox() {
        navigate.to(FormPage.CheckboxForm);

        checkboxForm.setCheckboxSelected();

        assertThat(checkboxForm.checkboxText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_OPTIONS = asList("Option 1","Option 2","Option 3","Option 4");

    @Test
    public void multipleCheckboxes() {
        navigate.to(FormPage.CheckboxForm);

        assertThat(ALL_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );


        checkboxForm.checkAll();

        assertThat(ALL_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );

    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */

    RadioButtonsForm radioButtonsForm;

    @Test
    public void radioButtons() {
        navigate.to(FormPage.RadioButtonsForm);

        radioButtonsForm.selectRadioButton("Male");
        radioButtonsForm.getCheckedValue();

        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }

    MultipleRadioButtonsForm multipleRadioButtonsForm;

    @Test
    public void multipleRadioButtons() {
        navigate.to(FormPage.MultipleRadioButtonsForm);

        multipleRadioButtonsForm.selectGender("Male");
        multipleRadioButtonsForm.selectAge("15 - 50");
        multipleRadioButtonsForm.getValues();

        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex : Male")
                .contains("Age group: 15 - 50");
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */

    SelectListForm selectListForm;

    @Test
    public void selectList() {
        navigate.to(FormPage.SelectListForm);

        assertThat(selectListForm.selectedDay()).isEmpty();

        selectListForm.selectDay("Sunday");

        assertThat(selectListForm.selectedDay()).isEqualTo("Sunday");
    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */

    MultiSelectListFrom multiSelectListFrom;

    @Test
    public void multiSelectList() {
        navigate.to(FormPage.MultiSelectListFrom);

        assertThat(multiSelectListFrom.selectedStates()).isEmpty();

        multiSelectListFrom.selectState("California","Florida");

        assertThat(multiSelectListFrom.selectedStates()).containsExactly("California","Florida");

    }

    HoverAction hoverAction;

    @Test
    public void hover(){
        navigate.to(FormPage.HoverAction);

        hoverAction.hoverOverFigure(1);
        hoverAction.captionForFigure(1).shouldBeVisible();
        hoverAction.captionForFigure(1).shouldContainText("user1");

    }
}