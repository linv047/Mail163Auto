package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.AddressBookPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SentPage;

/**
 * Created by lenovo on 2017/9/14.
 */
public class Action {

    public static void login(WebDriver driver) throws Exception{
        LoginPage lp = new LoginPage(driver);
        lp.userName().sendKeys("lsq0472013");
        lp.password().sendKeys("lsq047");
        //Thread.sleep(10000);
        lp.loginBtn().click();
    }

    public static void sentEmail(WebDriver driver,String sentTo,String subject,String attachment,String content) throws Exception{
        MainPage mainPage = new MainPage(driver);
        mainPage.writeBtn().click();
        SentPage sentPage = new SentPage(driver);
        sentPage.sentTo().sendKeys(sentTo);
        sentPage.subject().sendKeys(subject);
        sentPage.attachment().sendKeys(attachment);
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));

        sentPage.content().sendKeys(content);

        driver.switchTo().defaultContent();
        sentPage.sentBtn().click();
    }

    public static void addContact(AddressBookPage abPage,String name,String email,String mobile) throws Exception{
        abPage.addBtn().click();
        abPage.nameInput().sendKeys(name);
        abPage.emailInput().sendKeys(email);
        abPage.mobileInput().sendKeys(mobile);
        abPage.okBtn().click();
    }

    public static void addContactWithoutPage(AddressBookPage abPage,String name,String email,String mobile) throws Exception{
        abPage.addBtn().click();
        abPage.nameInput().sendKeys(name);
        abPage.emailInput().sendKeys(email);
        abPage.mobileInput().sendKeys(mobile);
        abPage.okBtn().click();
    }



    public static boolean deleteContact(AddressBookPage abPage) throws Exception{
        if (abPage!=null){
            abPage.deleteBtn().click();
            abPage.okBtn().click();
            return true;
        }else {
            return false;
        }
    }
}
