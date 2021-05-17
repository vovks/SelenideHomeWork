package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;


public class CocktailsPage {

    @FindBy(css = ".selected span")
    private SelenideElement findSelectType;

    @FindBy(css = ".filter-options [data-value=\"red\"]")
    private SelenideElement selectRedWineCocktails;

    @FindBy(css = "[href=\"raspberry-rose\"]")
    private SelenideElement findRaspberryRoseRecipe;

    @FindBy(css = ".filter-options [data-value=\"bubbles\"]")
    private SelenideElement selectSparklingWineCocktails;

    @FindBy(css = "[data-types=\"bubbles\"], [data-types=\"red\"]")
    private ElementsCollection recipesOnPage;

    @FindBy(css = "[href=\"mulled-wine\"], [href=\"red-wine-spritzer\"], [href=\"chocolate-fondue\"], [href=\"yellow-tailshake\"], [href=\"red-hot-chocolate\"], [href=\"winter-red-spritz\"], [href=\"very-berry-slushie\"]")
    private ElementsCollection recipes;


    @Step
    public void clickSelectType(){
        findSelectType.click();
    }

    @Step
    public void clickOnRedWineCocktailsType(){
        selectRedWineCocktails.click();
    }

    @Step
    public ElementsCollection getListOfCocktailsRecipes(){
        return recipes;
    }

    @Step
    public RecipePage clickOnRaspberryRoseRecipe(){
        findRaspberryRoseRecipe.click();
        return page (RecipePage.class);
    }

    @Step
    public void clickOnSparklingWineCocktailsType(){
        selectSparklingWineCocktails.click();
    }

    @Step
    public SelenideElement checkMultipleType(){
        //return findSelectType.getText();
        return findSelectType;
    }

    @Step
    public ElementsCollection getListOfMultipleCocktailsRecipes(){
        return recipesOnPage;
        }

}
