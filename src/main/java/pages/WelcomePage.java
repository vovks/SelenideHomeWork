package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.page;


public class WelcomePage {

    public WelcomePage() {
        super();
    }

  /*  @Step
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(welcomeButton, 3);

    }*/

    @FindBy(css = "[for=\"confirm\"]")
    private SelenideElement getConfirmationText;

    @FindBy(css = "div.confirmation-checkbox > label")
    private SelenideElement confirmationCheckbox;

    @FindBy(css = ".agegate-selector-options")
    private SelenideElement elementSelect;

    @FindBy(css = "[value=Welcome][disabled]")
    private SelenideElement welcomeButtonIsDisabled;

    @FindBy(css = "[value=Welcome]")
    private SelenideElement welcomeButton;

    @Step
    public SelenideElement getConfirmationText(){
        return getConfirmationText;
    }

    @Step
    public SelenideElement getConfirmationCheckbox(){
        return confirmationCheckbox;
    }

    @Step
    public SelenideElement getElementSelect(){
        return elementSelect;
    }

    @Step
    public SelenideElement checkWelcomeButtonIsDisabled(){
        return welcomeButtonIsDisabled;
    }

    @Step
    public MainPage welcomePageIsPassed(){
        confirmationCheckbox.click();

        Select select = new Select(elementSelect);
        select.selectByIndex(3);

        welcomeButton.click();
        return page (MainPage.class);
    }

}

