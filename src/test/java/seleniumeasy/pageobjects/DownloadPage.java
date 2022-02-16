package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class DownloadPage extends PageObject {

    public void downloadFileWithName(String fileName) {
        $(By.linkText(fileName)).click();
    }
}
