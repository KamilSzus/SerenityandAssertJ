package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class ProductPageListObjects extends PageObject {

    @Step("Get list of products from page")
    public List<String> getListOfProductsOnPage(){
        return findAll(".inventory_item_name").textContents();
    }
}
