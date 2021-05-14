package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;


public class MainPage {

    @FindBy (css = ".fa.fa-bars span")
    private SelenideElement elementMenu;

    @FindBy (css = ".content.animation-screen.-one >h2")
    private SelenideElement bigText;

    @FindBy (css = ".content.animation-screen.-one > .header-sub-copy")
    private SelenideElement smallerText;

    @FindBy (css = ".content.animation-screen.-one > .button.home-button")
    private SelenideElement findWineButton;

    @FindBy (id = "primary-footer")
    private SelenideElement elementFooter;

    @FindBy (css = ".main-nav [href$='/stores/']")
    private SelenideElement headerWhereToBuy;

    @FindBy (css = ".main-nav [href$='/cocktails/']")
    private SelenideElement headerCocktails;

    @FindBy (css = ".main-nav [href='#']")
    private SelenideElement headerCountrySelect;

    @FindBy (css = ".main-nav [href$='/wines/'], .main-nav [href$='/stores/'], .main-nav [href$='/cocktails/'], .main-nav [href$='/our-story/'], .main-nav [href$='/faqs/'], .main-nav [href$='/contact/'], .main-nav [href='#']")
    ElementsCollection headerLinks;

    @FindBy (css = ".top-nav.-active [href$='.com']")
    private SelenideElement headerYellowTail;

    @FindBy (css = "[href$='cn/']")
    private SelenideElement countryChina;


    @Step
    public SelenideElement getElementMenu(){
        //return elementMenu.getText();
        return elementMenu;
    }

    @Step
    public SelenideElement searchElementMenu(){
        //elementMenu.isDisplayed();
        return elementMenu;
    }

    @Step
    public SelenideElement searchBigText(){
        //bigText.isDisplayed();
        return bigText;
    }

    @Step
    public SelenideElement searchSmallerText(){
       // smallerText.isDisplayed();
        return smallerText;
    }

    @Step
    public SelenideElement searchFindWineButton(){
        //findWineButton.isDisplayed();
        return findWineButton;
    }

    @Step
    public SelenideElement searchElementFooter(){
        //elementFooter.isDisplayed();
        return elementFooter;
    }

    @Step
    public void clickElementMenu(){
        elementMenu.click();
    }

    @Step
    /*public boolean getHeaderLinks(){
        List<WebElement> headerLinks = new ArrayList<>();

        headerLinks.add(headerWines);
        headerLinks.add(headerWhereToBuy);
        headerLinks.add(headerCocktails);
        headerLinks.add(headerOurStory);
        headerLinks.add(headerFaqs);
        headerLinks.add(headerContactUs);
        headerLinks.add(headerCountrySelect);

        for (WebElement item: headerLinks) {
            if (!item.isDisplayed()) {
                return false;
            }
        }
        return true;
    }*/

    public ElementsCollection getHeaderLinks(){
        return headerLinks;
    }

    @Step
    public void clickYellowTailElement(){
        headerYellowTail.click();
    }

    @Step
    public void clickCountrySelect(){
        headerCountrySelect.click();
    }

    @Step
    public ChinaYellowTailPage clickCountryChina(){
        countryChina.click();
        return page (ChinaYellowTailPage.class);
    }

    @Step
    public WhereToBuyPage clickWhereToBuy(){
        headerWhereToBuy.click();
        return page (WhereToBuyPage.class);
    }

    @Step
    public CocktailsPage clickCocktails(){
        headerCocktails.click();
        return page(CocktailsPage.class);
    }

}
