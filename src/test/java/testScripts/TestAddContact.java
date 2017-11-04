package testScripts;

import appModules.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AddressBookPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import util.ExcelUtil;
import util.Finder;

/**
 * Created by lenovo on 2017/9/14.
 */
public class TestAddContact extends BaseTest {
    LoginPage loginPage = null;
    MainPage mainPage = null;
    AddressBookPage abPage = null;


    @Test
    public void testAddContact() throws Exception {
        loginPage = new LoginPage(driver);
        WebElement iframe = new Finder(driver).finder(By.id("x-URS-iframe"));
        driver.switchTo().frame(iframe);

        Action.login(driver);

        mainPage = new MainPage(driver);
        mainPage.addressBookBtn().click();

        abPage = new AddressBookPage(driver);
        Action.addContact(abPage,"Name","mail@163.com","15211112222");

    }

    @Test
    public void testAddContactByExcel() throws Exception {
        loginPage = new LoginPage(driver);
        WebElement iframe = new Finder(driver).finder(By.id("x-URS-iframe"));
        driver.switchTo().frame(iframe);

        Action.login(driver);

        mainPage = new MainPage(driver);
        mainPage.addressBookBtn().click();

        abPage = new AddressBookPage(driver);
        ExcelUtil.setExcelFile("D:\\test.xlsx","Sheet1");
        Action.addContact(abPage,
                ExcelUtil.getCellData(1,1),
                ExcelUtil.getCellData(1,2),
                ExcelUtil.getCellData(1,3));

    }


    @DataProvider(name = "testData")
    public static Object[][] data() throws Exception {
        return ExcelUtil.getTestData("D:\\test.xlsx","Sheet1");
    }

    @Test(dataProvider = "testData")
    public void testAddContactByExcel2() throws Exception {
        loginPage = new LoginPage(driver);
        WebElement iframe = new Finder(driver).finder(By.id("x-URS-iframe"));
        driver.switchTo().frame(iframe);

        Action.login(driver);

        mainPage = new MainPage(driver);
        mainPage.addressBookBtn().click();

        abPage = new AddressBookPage(driver);
        ExcelUtil.setExcelFile("D:\\test.xlsx","Sheet1");
        Action.addContact(abPage,
                ExcelUtil.getCellData(1,1),
                ExcelUtil.getCellData(1,2),
                ExcelUtil.getCellData(1,3));

    }



    @AfterMethod
    public void tearDown() throws Exception {
       Action.deleteContact(abPage);
        Thread.sleep(2000);
        driver.quit();
    }
}
