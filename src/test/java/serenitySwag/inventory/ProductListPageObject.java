package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> getListOfProductsOnPage(){
        return findAll(".inventory_item_name").textContents();
    }
    public void openProductsDetailsFor(String itemName){
        find(By.linkText(itemName)).click();
    }
}
