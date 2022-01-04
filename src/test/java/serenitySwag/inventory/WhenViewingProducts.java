package serenitySwag.inventory;

import net.serenitybdd.core.Serenity;
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
    @Steps
    ViewProductDetailsAction viewProductDetails;

    ProductList productList;
    ProductDetails productDetails;

    @Test
    public void checkProductsListOnPage(){
        loginAction.loginAS(User.STANDARD_USER);
       List<String> listOfProducts = productList.getListOfProductsOnPage();

        assertThat(listOfProducts).hasSize(6)
                .contains("Sauce Labs Bike Light");
    }

    @Test
    public void shouldDisplayAllImage(){
        loginAction.loginAS(User.STANDARD_USER);
        List<String> listOfProducts = productList.getListOfProductsOnPage();

        listOfProducts.forEach(
                productsName -> assertThat(productList.imageTextForProducts(productsName)).isEqualTo(productsName)
        );

    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        loginAction.loginAS(User.STANDARD_USER);
        String productName = productList.getListOfProductsOnPage().get(1);
        viewProductDetails.forProductWithName(productName);

        Serenity.reportThat("The product name should be correctly displayed",
                () -> assertThat(productDetails.productName()).isEqualTo(productName));
        Serenity.reportThat("The product image should have the correctly alt text",
                () ->productDetails.checkIfImageIsVisible(productName).shouldBeVisible());


    }
}
