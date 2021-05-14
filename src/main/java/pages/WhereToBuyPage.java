package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhereToBuyPage {

    @FindBy(id = "locationName")
    private SelenideElement findElementLocation;

    @FindBy(css = ".search-submit")
    private SelenideElement findSearchSubmitButton;

    @FindBy(css = ".tiles > .tile")
    private SelenideElement findElementResults;

    @Step
    public void clickOnElementLocation(){
        findElementLocation.click();
    }

    @Step
    public void clickSearchButton(){
        findSearchSubmitButton.click();
    }

    @Step
    public void sendTextInLocationField(){
        findElementLocation.click();
        findElementLocation.setValue("Austrian Club");
    }

    @Step
    public SelenideElement getElementResults(){
       // return findElementResults.isDisplayed();
        return findElementResults;
    }
}
