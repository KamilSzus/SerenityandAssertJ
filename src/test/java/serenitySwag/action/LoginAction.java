package serenitySwag.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

//Example how to find element in by using id

public class LoginAction extends UIInteractionSteps {

    @Step("Login as {0}")
    public void loginAS(User user){
        openUrl("https://www.saucedemo.com/");

        $("#user-name").sendKeys(user.getUserLogin());
        $("#password").sendKeys(user.getUserPassword());
        $("#login-button").click();
    }
}
