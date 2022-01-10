package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html")
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
