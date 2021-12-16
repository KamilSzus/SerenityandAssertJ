package serenitySwag.authentication;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.authentication.action.LoginAction;
import serenitySwag.authentication.inventory.InventoryAction;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {
    @Managed
    WebDriver webDriver;

    @Steps
    LoginAction loginAction;
    InventoryAction inventoryAction;

    @Test
    public void loggingIn(){
        loginAction.loginAsStandardUser();

        assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products");
    }
}
