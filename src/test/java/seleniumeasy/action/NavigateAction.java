package seleniumeasy.action;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigateAction extends UIInteractionSteps {
    public void to(FormPage formPage){
        openPageNamed(formPage.name());
    }
}
