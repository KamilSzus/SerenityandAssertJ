package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import org.openqa.selenium.By;

public class ProductDetails extends PageObject {


    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState checkIfImageIsVisible(String product) {
        return $((".inventory_details_container img[alt = '"+product+"']"));
    }
}
