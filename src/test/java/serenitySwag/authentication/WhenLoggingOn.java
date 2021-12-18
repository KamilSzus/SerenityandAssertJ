package serenitySwag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.action.LoginAction;
import serenitySwag.action.User;
import serenitySwag.inventory.InventoryAction;

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
        loginAction.loginAS(User.STANDARD_USER);

        Serenity.reportThat("Check if heading is equal to \"Products\" ",()->
                assertThat(inventoryAction.getHeading()).isEqualToIgnoringCase("Products"));
    }
}
