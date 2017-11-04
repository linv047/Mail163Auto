package testScripts;

import appModules.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import util.Finder;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/9/14.
 */
public class BaseTest2 {
    WebDriver driver;
    Finder finder;
    String baseURL = "http://mail.163.com/";

    //@BeforeMethod
    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        finder = new Finder(driver);
        driver.get(baseURL);

        LoginPage loginPage = null;
        MainPage mainPage = null;


        loginPage = new LoginPage(driver);
        WebElement iframe = new Finder(driver).finder(By.id("x-URS-iframe"));
        driver.switchTo().frame(iframe);

        Action.login(driver);

        mainPage = new MainPage(driver);
        mainPage.addressBookBtn().click();



    }

    //@AfterMethod
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}
