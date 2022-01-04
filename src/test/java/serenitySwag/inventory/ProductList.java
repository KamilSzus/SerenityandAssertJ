package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList extends PageObject {

    public List<String> getListOfProductsOnPage(){
        return findAll(".inventory_item_name").textContents();
    }

    public static By productDetailsLinkFor(String productName) {
        return By.linkText(productName);
    }

    public String imageTextForProducts(String productsName) {
        return $("//div[@class='inventory_item'][contains(.,'"+productsName+"')]//img").getAttribute("alt");
    }
}
