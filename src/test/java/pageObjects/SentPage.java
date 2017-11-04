package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenovo on 2017/9/13.
 */
public class SentPage extends BasePage{

    public SentPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement sentTo()throws Exception{
        element = map.getLocation("sentPage.sentTo",driver);
        return element;
    }

    public WebElement subject()throws Exception{
        return map.getLocation("sentPage.subject",driver);
    }

    public WebElement sentBtn()throws Exception{
        return map.getLocation("sentPage.sentBtn",driver);
    }

    public WebElement attachment()throws Exception{
        return map.getLocation("sentPage.attachment",driver);
    }

    public WebElement content()throws Exception{
        return map.getLocation("sentPage.content",driver);
    }
}
