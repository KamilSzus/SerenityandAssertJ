package seleniumeasy.pageobjects;

public class CheckboxForm extends SeleniumEasyForm {


    public void setCheckboxSelected() {
        $("#isAgeSelected").click();
    }

    public String checkboxText() {
        return $("#txtAge").getText();
    }

    public boolean optionIsCheckedFor(String option) {
        return $("//label[contains(.,'{0}')]/input",option).isSelected();
    }

    public void checkAll() {
        $("//input[@value='Check All']").click();
    }
}
