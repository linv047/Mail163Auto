package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LoggerControler;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by lenovo on 2017/9/11.
 * 用于实现在外部配置文件中配置页面元素的定位表达式
 */
public class ObjectMap {
    Properties properties;
    LoggerControler log = LoggerControler.getlogger(ObjectMap.class);

    public ObjectMap(String propFile){
        properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(propFile);
            properties.load(in);
            in.close();
        }catch (IOException e){
            System.out.println();
            e.printStackTrace();
        }
    }

    /*
    *loginPage.username = id>idInput
    * loginPage.password = id>pwdInput
    */
    public By getLocation(String ElementNameInpropFile) throws Exception{
        String locator = properties.getProperty(ElementNameInpropFile);
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];

        locatorValue = new String(locatorValue.getBytes("UTF-8"));

        log.info("获取的定位类型： "+locatorType+"\t 定位表达式： "+locatorValue);
        if ("id".equals(locatorType.toLowerCase()))
            return By.id(locatorValue);
        else if ("name".equals(locatorType.toLowerCase()))
            return By.name(locatorValue);
        else if ("classname".equals(locatorType.toLowerCase())||"class".equals(locatorType.toLowerCase()))
            return By.className(locatorValue);
        else if ("tagname".equals(locatorType.toLowerCase()))
            return By.tagName(locatorValue);
        else if ("linktext".equals(locatorType.toLowerCase()))
            return By.linkText(locatorValue);
        else if ("cssselector".equals(locatorType.toLowerCase()))
            return By.cssSelector(locatorValue);
        else if ("xpath".equals(locatorType.toLowerCase()))
            return By.xpath(locatorValue);
        else
            throw new Exception("定位方式未定义： "+locatorType);
    }

    public WebElement getLocation(String ElementNameInpropFile, WebDriver driver)throws Exception{
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getLocation(ElementNameInpropFile)));
        return element;
    }
}
