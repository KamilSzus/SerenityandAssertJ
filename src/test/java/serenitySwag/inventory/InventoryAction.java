package serenitySwag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class InventoryAction extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }
}
