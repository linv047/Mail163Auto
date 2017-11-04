package testScripts;

import appModules.Action;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Finder;



/**
 * Created by lenovo on 2017/9/13.
 */
public class TestSentMail extends BaseTest{

    @Test
    public void testSentMail() throws Exception {
        driver.get(baseURL);
        driver.switchTo().frame(new Finder(driver).finder(By.id("x-URS-iframe")));

        Action.login(driver);

        Thread.sleep(2000);

        Action.sentEmail(driver,"lsq0472013@163.com","Test Mail Subject",
                "D:\\0.jpeg","Test Mail Content....");

        Assert.assertTrue(finder.finder(By.xpath("//b[@class='nui-ico se0 pv1']")).isDisplayed());
    }
}
