package seleniumeasy.pageobjects;

public class RadioButtonsForm extends SeleniumEasyForm{

    public void selectRadioButton(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }
}
