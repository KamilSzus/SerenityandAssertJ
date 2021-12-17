package serenitySwag.authentication.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    @Step("Login as a standard user")
    public void loginAsStandardUser(){
        openUrl("https://www.saucedemo.com/");

        $(("[data-test='username']")).sendKeys("standard_user");
        $(("[data-test='password']")).sendKeys("secret_sauce");
        $(("[data-test='login-button']")).click();
    }

    @Step("Login as a problem user")
    public void loginAsProblemUser(){
        openUrl("https://www.saucedemo.com/");

        $(("[data-test='username']")).sendKeys("problem_user");
        $(("[data-test='password']")).sendKeys("secret_sauce");
        $(("[data-test='login-button']")).click();
    }
}
