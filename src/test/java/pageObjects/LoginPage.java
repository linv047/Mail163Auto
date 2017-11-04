package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.HighlightUtil;

/**
 * Created by lenovo on 2017/9/11.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement userName() throws Exception{
        element = map.getLocation("loginPage.username",driver);
        HighlightUtil.highlightElement(element,driver);
        return element;
    }

    public WebElement password() throws Exception {
        element = map.getLocation("loginPage.password",driver);
        HighlightUtil.highlightElement(element,driver);
        return element;
    }

    public WebElement loginBtn()throws Exception{
        element = map.getLocation("loginPage.loginBtn",driver);
        HighlightUtil.highlightElement(element,driver);
        return element;
    }

    public void loginAction(String username,String psd,WebDriver driver) throws Exception {
        LoginPage lp = new LoginPage(driver);
        lp.userName().sendKeys(username);
        lp.password().sendKeys(psd);
        lp.loginBtn().click();
    }
}
