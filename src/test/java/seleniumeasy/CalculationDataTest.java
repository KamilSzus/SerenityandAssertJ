package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.action.FormPage;
import seleniumeasy.action.NavigateAction;
import seleniumeasy.pageobjects.TwoInputFieldsForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
//@Concurrent
@UseTestDataFrom("test-data/DataForCalculationTest.csv")
public class CalculationDataTest {
    private String a;
    private String b;
    private String total;

    @Managed(options = "--headless")
    WebDriver driver;
    @Steps
    NavigateAction navigateAction;
    TwoInputFieldsForm twoInputFieldsForm;

    //@TestData
    //public static Collection<Object[]> testData(){
    //    return Arrays.asList(
    //            new Object[][]{
    //                    {"1","2","3"}
    //                    ,{"10","20","30"}
    //                    ,{"5","10","15"}
    //                    ,{"100","209","309"}
    //            }
    //    );
    //}

    @Test
    public void shouldCalculateCorrectTotal(){
        navigateAction.to(FormPage.TwoInputFieldsForm);

        twoInputFieldsForm.enterFirstNumber(a);
        twoInputFieldsForm.enterSecondNumber(b);
        twoInputFieldsForm.getTotal();

        assertThat(twoInputFieldsForm.displayNumber()).isEqualTo(total);
    }
}
