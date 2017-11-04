package testScripts;

import appModules.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pageObjects.AddressBookPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import util.Finder;
import util.LoggerControler;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/9/14.
 */
public class BaseTest {
    WebDriver driver;
    Finder finder;
    String baseURL = "http://mail.163.com/";
    LoggerControler log = LoggerControler.getlogger(BaseTest.class);


    @BeforeMethod
    public void setUp() throws Exception {
        log.info("################### Start test #############");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MILLISECONDS);
        finder = new Finder(driver);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}
