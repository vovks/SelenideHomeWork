import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;;


public class HomeworkSelenide extends SelenideRunner{
    @Test
    //Case 1: Welcome page: all required elements are displayed
    public void navigationWelcomePageElements() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);

        welcomePage.getConfirmationText().shouldHave(text("I am of legal drinking age in"));
        welcomePage.getConfirmationCheckbox().shouldBe(visible);
        welcomePage.getElementSelect().shouldBe(visible);
        welcomePage.checkWelcomeButtonIsDisabled().shouldBe(visible);

    }

    @Test
    //Case 2: Welcome page: navigate to main page as European customer
    public void navigationWelcomePageEurope() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

       mainPage.getElementMenu().shouldHave(text("MENU")).shouldNotHave(text("no-scroll"));
    }

    @Test
    //Case 3: Main page: all required elements are displayed
    public void navigationMainPageElements() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        mainPage.searchElementMenu().shouldBe(visible);
        mainPage.searchBigText().shouldBe(visible);
        mainPage.searchSmallerText().shouldBe(visible);
        mainPage.searchFindWineButton().shouldBe(visible);
        mainPage.searchElementFooter().shouldBe(visible);

    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    public void verifyingHeaderOpening() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        mainPage.clickElementMenu();

        ElementsCollection searchHeaderLinks = mainPage.getHeaderLinks();
        for(SelenideElement item: searchHeaderLinks){
            item.shouldBe(visible);
        }

        mainPage.clickYellowTailElement();
        mainPage.searchElementMenu().shouldBe(visible);
    }

    @Test
    //Case 5: Main page: Menu button logic (close header)
    public void verifyingHeaderClosing() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        mainPage.clickElementMenu();
        mainPage.clickYellowTailElement();

        mainPage.searchElementMenu().shouldBe(visible);

    }

    @Test
    //Case 6: Main page: Global Nav logic
    public void navigateToChina() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        mainPage.clickCountrySelect();

        ChinaYellowTailPage chinaPage = mainPage.clickCountryChina();

        chinaPage.checkFindWineButtonChina().shouldHave(text("发现适合你的酒"));
    }

    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    public void navigationChinaWeiboTab() {
        //driver.manage().deleteAllCookies();
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        mainPage.clickCountrySelect();

        ChinaYellowTailPage chinaPage = mainPage.clickCountryChina();
        chinaPage.clickWeiboButton();

        /*int winHandleNum = DriverProvider.getDriver().getWindowHandles().size();
        if (winHandleNum > 1) {
            for (String winHandle: DriverProvider.getDriver().getWindowHandles()){
                DriverProvider.getDriver().switchTo().window(winHandle);
            }
        }

        Boolean explicitWait = (new WebDriverWait(DriverProvider.getDriver(),Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe("https://weibo.com/yellowtailChina"));

        Assertions.assertTrue(DriverProvider.getDriver().getCurrentUrl().contains("https://weibo.com/yellowtailChina"));*/

    }

    @Test
    //Case 8: Where to buy: enter valid postal code
    public void navigateToStores() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        WhereToBuyPage storesPage = mainPage.clickWhereToBuy();

        storesPage.sendTextInLocationField();
        storesPage.clickSearchButton();

        storesPage.getElementResults().shouldBe(visible);
    }

    @Test
    //Case 9: Cocktails: Select one wine
    public void navigationCocktails() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        cocktailsPage.clickSelectType();
        cocktailsPage.clickOnRedWineCocktailsType();
        cocktailsPage.clickSelectType();

        ElementsCollection searchRecipes = cocktailsPage.getListOfCocktailsRecipes();
        for(SelenideElement item: searchRecipes){
            item.shouldBe(visible);
        }
    }

    @Test
    //Case 10: Cocktails: Navigate to Cocktail recipe page
    public void navigationCocktailRecipe() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        RecipePage recipePage = cocktailsPage.clickOnRaspberryRoseRecipe();

        recipePage.checkIngredients().shouldBe(visible);
    }

    @Test
    //Case 11: Cocktails: Select several wines
    public void navigationSeveralWineCocktail() {
        WelcomePage welcomePage = open(Constants.BASIC_URL, WelcomePage.class);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        cocktailsPage.clickSelectType();
        cocktailsPage.clickOnRedWineCocktailsType();
        cocktailsPage.clickOnSparklingWineCocktailsType();

        cocktailsPage.checkMultipleType().shouldHave(text("Multiple"));
        cocktailsPage.getListOfMultipleCocktailsRecipes().shouldHaveSize(18);
    }

}
