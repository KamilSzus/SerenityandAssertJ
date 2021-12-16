package serenitySwag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {

    @Managed
    WebDriver webDriver;

    @Test
    public void loggingIn(){

        webDriver.get("https://www.saucedemo.com/");

        webDriver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        webDriver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");

        webDriver.findElement(By.cssSelector("[data-test='login-button']")).click();

        assertThat(webDriver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("Products");




    }
}
