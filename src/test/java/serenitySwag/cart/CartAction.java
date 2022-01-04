package serenitySwag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenitySwag.inventory.InventoryAction;
import serenitySwag.inventory.ProductList;

import java.util.List;

public class CartAction extends UIInteractionSteps {
    @Step("Open the shopping Cart")
    public void openCart(){
        $(ShoppingCartIcon.findCart()).click();
    }
    @Step("Add product '{0}' to cart")
    public void addItem(String productName){
        $(ProductList.productButton(productName)).click();
    }
    @Step("Add product '{0}' to cart")
    public void addItems(List<String> productNamesList){
        productNamesList.forEach(this::addItem);
    }
}
