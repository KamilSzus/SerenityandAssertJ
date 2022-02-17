package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.action.FormPage;
import seleniumeasy.action.NavigateAction;
import seleniumeasy.pageobjects.TwoInputFieldsForm;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
//@Concurrent
public class CalculationDataTest {
    final String a;
    final String b;
    final String total;

    @Managed
    WebDriver driver;

    public CalculationDataTest(String a, String b, String total) {
        this.a = a;
        this.b = b;
        this.total = total;
    }

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(
                new Object[][]{
                        {"1","2","3"}
                        ,{"10","20","30"}
                        ,{"5","10","15"}
                        ,{"100","209","309"}
                }
        );
    }

    @Steps
    NavigateAction navigateAction;
    TwoInputFieldsForm twoInputFieldsForm;


    @Test
    public void shouldCalculateCorrectTotal(){
        navigateAction.to(FormPage.TwoInputFieldsForm);

        twoInputFieldsForm.enterFirstNumber(a);
        twoInputFieldsForm.enterSecondNumber(b);
        twoInputFieldsForm.getTotal();

        assertThat(twoInputFieldsForm.displayNumber()).isEqualTo(total);
    }
}
