package serenitySwag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewProductDetailsAction extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void forProductWithName(String productName) {
        $(ProductList.productDetailsLinkFor(productName)).click();
    }
}
