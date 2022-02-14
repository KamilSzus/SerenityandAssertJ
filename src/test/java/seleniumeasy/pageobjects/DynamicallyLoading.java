package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

import java.time.Duration;

public class DynamicallyLoading extends SeleniumEasyForm {

    public void getNewUser() {
        $(FormButton.withLabel("Get New User")).click();
        withTimeoutOf(Duration.ofSeconds(50)).waitForAllTextToAppear("First Name :");
    }

    public String getUserData() {
        return $(By.id("loading")).getText();
    }
}
