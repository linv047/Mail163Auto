package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenovo on 2017/9/14.
 */
public class AddressBookPage extends BasePage {

    public AddressBookPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement addBtn() throws Exception{
        element = map.getLocation("addressBookPage.addBtn",driver);
        return element;
    }

    public WebElement nameInput() throws Exception{
        element = map.getLocation("addressBookPage.nameInput",driver);
        return element;
    }

    public WebElement emailInput() throws Exception{
        element = map.getLocation("addressBookPage.emailInput",driver);
        return element;
    }

    public WebElement mobileInput() throws Exception{
        element = map.getLocation("addressBookPage.mobileInput",driver);
        return element;
    }

    public WebElement okBtn() throws Exception{
        element = map.getLocation("addressBookPage.okBtn",driver);
        return element;
    }

    public WebElement deleteBtn() throws Exception{
        element = map.getLocation("addressBookPage.deleteBtn",driver);
        return element;
    }
}
