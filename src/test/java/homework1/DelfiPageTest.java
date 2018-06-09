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

    private WebDriver driver; /*Korobka i nazvanie peremennoj*/

    @Before
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");

        driver = new FirefoxDriver(); // realizacija drivera

        driver.manage().window().maximize();
    }

    @Test
    public void shouldCheckIfArticleExist() {

        //Arrange
        String statja = "В воскресенье в Латвии ожидается жара до +27 градусов";

        //Act
        driver.get(LINK_TO_DELFI);
        WebElement linknastatju = driver.findElement(By.linkText(statja));

        //Assert
        boolean statjaPokazivajetsa = linknastatju.isDisplayed();
        assertTrue(statjaPokazivajetsa);
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
