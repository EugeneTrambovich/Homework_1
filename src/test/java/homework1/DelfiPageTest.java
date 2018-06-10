package homework1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class DelfiPageTest {

    private static final String LINK_TO_DELFI = "https://rus.delfi.lv/";

    private WebDriver driver; /*Box and name for variable*/

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");

        driver = new FirefoxDriver(); // Driver realisation.

        driver.manage().window().maximize();
    }

    @Test
    public void shouldCheckIfArticleExist() {

        //Arrange
        String ourarticle = "Вся правда о выпускных: популярные мифы и полезные советы";

        //Act
        driver.get(LINK_TO_DELFI);
        WebElement linkforourarticle = driver.findElement(By.linkText(ourarticle));

        //Assert
        boolean articleisshown= linkforourarticle.isDisplayed();
        assertTrue(articleisshown);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
