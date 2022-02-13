package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.action.FormPage;
import seleniumeasy.action.NavigateAction;
import seleniumeasy.pageobjects.AlertMessage;
import seleniumeasy.pageobjects.ModalDialog;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    AlertMessage alertMessage;

    @Test
    public void waitingForAMessageToClose() {
        alertMessage.open();

        alertMessage.isAlertLunch().shouldNotBeVisible();
        alertMessage.runAlert();

        alertMessage.isAlertLunch().shouldBeVisible();
        assertThat(alertMessage.getTextFromAlertMessage())
                .contains("I'm an autocloseable success message. I will hide in 5 seconds.");

        alertMessage.waitForDisappearAlert();

        alertMessage.isAlertLunch().shouldNotBeVisible();
    }

    @Test
    public void waitingForElementsToAppear() {
    }
}