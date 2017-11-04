package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import util.Finder;

/**
 * Created by lenovo on 2017/9/12.
 */
public class TestMailLogin extends BaseTest {

    @Test
    public void testLogin() throws Exception {

        driver.get(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        WebElement iframe = new Finder(driver).finder(By.id("x-URS-iframe"));
        driver.switchTo().frame(iframe);

        loginPage.loginAction("lsq0472013", "lsq047", driver);

        Assert.assertEquals(finder.finder(By.linkText("退出")).getText(), "退出");

    }
}
