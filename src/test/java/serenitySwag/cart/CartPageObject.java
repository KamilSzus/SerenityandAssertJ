package serenitySwag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    private static By CHECKOUT_BUTTON = By.name("checkout");
    private static By CART_ITEM = By.cssSelector(".cart_item");

    public void checkout(){
        find(CHECKOUT_BUTTON).click();
    }

    public List<CartItem> items() {
      return findAll(CART_ITEM).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceForm(item.findBy(".inventory_item_price").getText())
                )
        );
    }

    private Double priceForm(String textValue) {
        return Double.parseDouble(textValue.replace("$",""));
    }
}
