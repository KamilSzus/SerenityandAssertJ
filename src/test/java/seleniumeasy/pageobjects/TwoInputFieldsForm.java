package seleniumeasy.pageobjects;

public class TwoInputFieldsForm extends  SeleniumEasyForm {

    public void enterFirstNumber(String firstNumber) {
        $("#sum1").sendKeys(firstNumber);
    }

    public void enterSecondNumber(String secondNumber) {
        $("#sum2").sendKeys(secondNumber);
    }

    public void getTotal() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayNumber() {
        return $("#displayvalue").getText();
    }
}
