package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class ModalDialog extends SeleniumEasyForm {

    private static final By SAVE_CHANGES = By.linkText("Save changes");

    public void openModal(){
        find(By.linkText("Launch modal")).click();
    }

    public void saveModal(){
        find(SAVE_CHANGES).click();
    }

    public WebElementState isModalLunch(){
      return find(SAVE_CHANGES);
    }
}
