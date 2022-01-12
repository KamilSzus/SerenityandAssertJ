package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
public class DoubleInputFieldsForm extends  SeleniumEasyForm {

    public void enterFirstNumber(String firstNumber) {
        $("#sum1").sendKeys(firstNumber);
    }

    public void enterSecondNumber(String secondNumber) {
        $("#sum2").sendKeys(secondNumber);
    }

    public void displayNumbers() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayNumber() {
        return $("#displayvalue").getText();
    }
}
