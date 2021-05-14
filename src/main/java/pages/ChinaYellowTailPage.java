package pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;


public class ChinaYellowTailPage {

    @FindBy(css = "[href=\"/basic\"]>.sgg-comp-button-inner")
    private SelenideElement findWineButtonChina;

    @FindBy(css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private SelenideElement findWeiboButton;

    @Step
    public SelenideElement checkFindWineButtonChina(){
        //return findWineButtonChina.getText();
        return findWineButtonChina;
    }

    @Step
    public void clickWeiboButton(){
        findWeiboButton.click();
    }


}
