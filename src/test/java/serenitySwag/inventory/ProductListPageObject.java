package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> getListOfProductsOnPage(){
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductsDetailsFor(String itemName){
        find(By.linkText(itemName)).click();
    }

    public WebElementState checkIfImageIsVisible(String product) {
        return $((".inventory_details_container img[alt = '"+product+"']"));
    }

    public String imageTextForProducts(String productsName) {
        return $("//div[@class='inventory_item'][contains(.,'"+productsName+"')]//img").getAttribute("alt");
    }
}
