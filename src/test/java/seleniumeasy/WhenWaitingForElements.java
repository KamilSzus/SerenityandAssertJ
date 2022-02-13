package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.action.FormPage;
import seleniumeasy.action.NavigateAction;
import seleniumeasy.pageobjects.ModalDialog;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;
    @Steps
    NavigateAction navigate;

    ModalDialog modalDialog;

    @Test
    public void waitingForAModalDialog() {
        navigate.to(FormPage.ModalDialog);
        modalDialog.isModalLunch().shouldNotBeVisible();
        modalDialog.openModal();

        modalDialog.isModalLunch().shouldBeVisible();

        modalDialog.saveModal();

        modalDialog.isModalLunch().shouldNotBeVisible();
    }

    @Test
    public void waitingForAMessageToClose() {
    }

    @Test
    public void waitingForElementsToAppear() {
    }
}