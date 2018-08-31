package homework2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BaseFunc {
    private WebDriver driver;

    
    public BaseFunc() {
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
       
        Assert.assertFalse("Element not found", getElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
