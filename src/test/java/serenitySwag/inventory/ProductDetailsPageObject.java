package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductDetailsPageObject extends PageObject {


    public String productName() {
        return $(".inventory_details_name").getText();
    }
}
