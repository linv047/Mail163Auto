package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lenovo on 2017/9/12.
 */
public class Finder {
    private  WebDriver driver;
    public Finder(WebDriver driver){
        this.driver = driver;
    }
    public  WebElement finder(By by){
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }
}
