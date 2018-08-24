package homework2version2;

import homework2.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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

    public List<OneHoroscope> getAllHoroscopes() {
        List<OneHoroscope> horoscopes = new ArrayList<OneHoroscope>();
        for (WebElement element : baseFunc.getElements(HOROSCOPE_LIST)) {
            String horoscopeName = element.findElement(HOROSCOPE_SIGN_TITLE).getText();
            horoscopes.add(new OneHoroscope(horoscopeName, getHoroscopeDate(horoscopeName)));
        }
        return horoscopes;
    }

    public class OneHoroscope {
        private String horoscopeName;
        private String horoscopeDate;


        public OneHoroscope(String horoscopeName, String horoscopeDate) {
            this.horoscopeName = horoscopeName;
            this.horoscopeDate = horoscopeDate;
        }

        public String getHoroscopeName() {
            return horoscopeName;
        }

        public String getHoroscopeDate() {
            return horoscopeDate;
        }

        public void openHoroscope() {
            openHoroscopePage(horoscopeName);
        }
    }
}
