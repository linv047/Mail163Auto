package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by lenovo on 2017/9/17.
 */
public class HighlightUtil {
    public static void highlightElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,
                "background: yellow;border: 2px solid red;");
    }
}
