package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;

public class HighLightDriver extends ChromeDriver {
    @Override
    public WebElement findElement(By by) {
        WebElement elem = super.findElement(by);
        // draw a border around the found element
        if (this instanceof JavascriptExecutor) {
            ((JavascriptExecutor)this).executeScript("arguments[0].style.border='3px solid yellow'", elem);
        }
        try {
            sleep(1500l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return elem;
    }
}