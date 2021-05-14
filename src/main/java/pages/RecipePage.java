package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecipePage {

    @FindBy(css = ".ingredients")
    private SelenideElement findIngredients;

    @Step
    public SelenideElement checkIngredients(){
       // findIngredients.isDisplayed();
        return findIngredients;
    }
}
