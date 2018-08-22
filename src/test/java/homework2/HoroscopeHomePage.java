package homework2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HoroscopeHomePage {
    private final By HOROSCOPE_LIST = By.className("hrsc-list");
    private final By HOROSCOPE_DATE = By.className("hrsc-list-date");
    private final By HOROSCOPE_SIGN_TITLE = By.className("hrsc-list-title");
    private static final Logger LOGGER = LogManager.getLogger(HoroscopeHomePage.class);


    private BaseFunc baseFunc;

    public HoroscopeHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getHoroscopeDate(String name) {
        WebElement horoscopeElement = getHoroscopeElement(name);
        List<WebElement> dateElements = horoscopeElement.findElements(HOROSCOPE_DATE);
        String date1 = dateElements.get(0).getText();
        String date2 = dateElements.get(1).getText();
        String fullDate = date1+ date2;
        LOGGER.info(fullDate);
        return fullDate.replace(" ", "");



    }

    public void openHoroscopePage(String name) {

        getHoroscopeElement(name).click();

    }

    private WebElement getHoroscopeElement(String name) {
        List<WebElement> horoscopeElements = baseFunc.getElements(HOROSCOPE_LIST);

        // access each element in horoscope list
        for (WebElement element : horoscopeElements) {
            String horoscopeName = element.findElement(HOROSCOPE_SIGN_TITLE).getText();
            LOGGER.info(horoscopeName);
            if (name.equalsIgnoreCase(horoscopeName)){
                return element;
            }

        }

        throw new IllegalArgumentException( "Cannot find horoscope with name " + name);
    }
}
