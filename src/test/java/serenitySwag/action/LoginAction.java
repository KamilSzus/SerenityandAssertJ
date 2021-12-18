package serenitySwag.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    @Step("Login as {0}")
    public void loginAS(User user){
        openUrl("https://www.saucedemo.com/");

        $(("[data-test='username']")).sendKeys(user.getUserLogin());
        $(("[data-test='password']")).sendKeys(user.getUserPassword());
        $(("[data-test='login-button']")).click();
    }
}
