package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
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

    public static By productButton(String productName){
        return By.xpath("//div[@class='inventory_item'][contains(.,'"+productName+"')]//button");
    }

    public String checkIfCartContains(String productName) {
        return $("//div[@class = 'cart_list']//a[contains(.,'"+productName+"')]").getText();
    }
}
