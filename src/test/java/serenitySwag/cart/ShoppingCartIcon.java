package serenitySwag.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartIcon extends PageObject {
    public String checkNumberOfProductsInCartIcon(){
        return $("//*[@class='shopping_cart_container']/a/span").getAttribute("innerHTML");
    }

    public static By findCart() {
        return By.id("shopping_cart_container");
    }
}
