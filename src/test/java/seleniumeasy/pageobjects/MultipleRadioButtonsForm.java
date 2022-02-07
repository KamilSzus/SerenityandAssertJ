package seleniumeasy.pageobjects;

public class MultipleRadioButtonsForm extends SeleniumEasyForm{

    public void selectGender(String gender) {
        inRadioButtonGroup("gender").selectByValue(gender);
    }

    public void selectAge(String age) {
        inRadioButtonGroup("ageGroup").selectByValue(age);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return $(".groupradiobutton").getText();
    }
}
