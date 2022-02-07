package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

public class SingleInputFieldsForm extends  SeleniumEasyForm {

    public void enterMessage(String message) {
        $("#user-message").sendKeys(message);
    }

    public void showMessage() {
        find(FormButton.withLabel("Show Message")).click();
    }

    public String displayMessage() {
        return find(By.id("display")).getText();
    }
}
