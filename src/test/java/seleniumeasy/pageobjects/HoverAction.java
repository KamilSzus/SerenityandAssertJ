package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

public class HoverAction extends PageObject {

    private static final String FIGURE_VISIBLE = "//*[@class='figure'][{0}]";
    private static final String FIGURE_CAPTURE = "(//*[@class='figcaption'])[{0}]";

    public void hoverOverFigure(int figureNumber) {
        WebElement figure = $(FIGURE_VISIBLE,figureNumber);

        withAction().moveToElement(figure)
                .perform();

    }

    public WebElementState captionForFigure(int figureNumber) {
        return $(FIGURE_CAPTURE,figureNumber);
    }
}
