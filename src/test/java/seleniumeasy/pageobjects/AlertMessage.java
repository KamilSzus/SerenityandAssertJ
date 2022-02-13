package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessage extends SeleniumEasyForm {

    private static final By ALERT_MESSAGE = By.cssSelector(".alert-autocloseable-success");

    public WebElementState isAlertLunch() {
        return $(ALERT_MESSAGE);
    }

    public void runAlert() {
        $("#autoclosable-btn-success").click();
    }

    public String getTextFromAlertMessage(){
        return $(ALERT_MESSAGE).getText();
    }

    public void waitForDisappearAlert() {
        withTimeoutOf(Duration.ofSeconds(10)).waitForElementsToDisappear(ALERT_MESSAGE);
    }
}
