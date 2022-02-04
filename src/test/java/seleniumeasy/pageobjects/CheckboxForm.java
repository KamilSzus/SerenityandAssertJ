package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/basic-checkbox-demo.html")
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
