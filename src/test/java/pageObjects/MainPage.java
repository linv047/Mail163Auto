package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenovo on 2017/9/13.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement writeBtn() throws Exception {
        element = map.getLocation("mainPage.writeBtn",driver);
        return element;
    }

    public WebElement addressBookBtn() throws Exception {
        element = map.getLocation("mainPage.addressBookBtn",driver);
        return element;
    }
}
