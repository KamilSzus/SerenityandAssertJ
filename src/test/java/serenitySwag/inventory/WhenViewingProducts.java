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
    @Managed(driver = "chrome")
    WebDriver webDriver;

    @Steps
    LoginAction loginAction;
    ProductListPageObject productListPageObject;
    ProductDetailsPageObject productDetailsPage;

    @Test
    public void checkProductsListOnPage(){
        loginAction.loginAS(User.STANDARD_USER);
       List<String> listOfProducts = productListPageObject.getListOfProductsOnPage();

        assertThat(listOfProducts).hasSize(6)
                .contains("Sauce Labs Bike Light");
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        loginAction.loginAS(User.STANDARD_USER);
        String product=productListPageObject.getListOfProductsOnPage().get(1);
        productListPageObject.openProductsDetailsFor(product);

        assertThat(productDetailsPage.productName()).isEqualTo(product);

    }
}
