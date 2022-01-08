package serenitySwag.cart;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitySwag.authentication.LoginAction;
import serenitySwag.authentication.User;
import serenitySwag.inventory.ProductList;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver webDriver;

    @Steps
    CartAction cartAction;

    LoginAction loginAction;
    ProductList productList;
    ShoppingCartIcon shoppingCartIcon;
    CartItem cartItem;
    CartPageObject cartPage;

    @Before
    public void loginOn(){
        loginAction.loginAS(User.STANDARD_USER);
    }

    @Test
    public void numberOfProductShouldBeCorrect(){
        int numberOfItemsInCart = addProductToCart().size();
        Serenity.reportThat("In The shopping cart should be "+numberOfItemsInCart +" items",
                () ->assertThat(shoppingCartIcon.checkNumberOfProductsInCartIcon()).isEqualTo("3"));
    }

    @Test
    public void checkIfTheCartContainsCorrectProducts(){
        List<String> productInCart = addProductToCart();
        cartAction.openCart();
        productInCart.forEach(
                productName -> Serenity.reportThat("Cart should contains " + productName,
                        () -> assertThat(productList.checkIfCartContains(productName)).isEqualTo(productName))
        );
    }

    @Test
    public void priceOfProductShouldBeCorrectlyDisplayedInCart(){
        addProductToCart();
        cartPage.open();
        List<CartItem> items = cartPage.items();
        Serenity.reportThat("The price in cart shouldn't be zero",
                ()->assertThat(items).hasSize(3).allMatch(item -> item.price() > 0.0));
    }

    private List<String> addProductToCart() {
        List<String> productInCart = productList.getListOfProductsOnPage().subList(0,3);
        cartAction.addItems(productInCart);
        return productInCart;
    }
}
