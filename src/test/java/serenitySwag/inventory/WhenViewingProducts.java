package serenitySwag.inventory;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.authentication.LoginAction;
import serenitySwag.authentication.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenViewingProducts {
    @Managed
    WebDriver webDriver;

    @Steps
    LoginAction loginAction;
    ProductPageListObjects productPageListObjects;

    @Test
    public void checkProductsListOnPage(){
        loginAction.loginAS(User.STANDARD_USER);
       List<String> listOfProducts = productPageListObjects.getListOfProductsOnPage();
        assertThat(listOfProducts).hasSize(6)
                .contains("Sauce Labs Bike Light");
    }
}
