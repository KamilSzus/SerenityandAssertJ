package serenitySwag.action;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

//How to find element using name

public class LoginAction extends UIInteractionSteps {

    @Step("Login as {0}")
    public void loginAS(User user){
        openUrl("https://www.saucedemo.com/");

        find(By.name("user-name")).sendKeys(user.getUserLogin());
        find(By.name("password")).sendKeys(user.getUserPassword());
        find(By.name("login-button")).click();
    }
}
