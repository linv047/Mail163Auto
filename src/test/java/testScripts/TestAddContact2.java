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
public class TestAddContact2 extends BaseTest2 {
    AddressBookPage abPage = null;


    @DataProvider(name = "testData")
    public static Object[][] data() throws Exception {
        return ExcelUtil.getTestData("D:\\test.xlsx","Sheet1");
    }

    @Test(dataProvider = "testData")
    public void testAddContactByExcel2(String name,String email,String mobile) throws Exception {

        abPage = new AddressBookPage(driver);
        Action.addContact(abPage,name,email,mobile);


    }



    @AfterMethod
    public void tearDown() throws Exception {
       //Action.deleteContact(abPage);
        Thread.sleep(2000);
        //driver.quit();
    }
}
