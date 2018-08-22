package homework2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HoroscopeDetailPage {

    private final By HOROSCOPE_DATE = By.className("hrsc-title-s");
    private static final Logger LOGGER = LogManager.getLogger(HoroscopeDetailPage.class);
    private final By DESCRIPTION_BUTTON = By.linkText("Zīmes raksturojums");

    private BaseFunc baseFunc;

    public HoroscopeDetailPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getHoroscopeDate() {
      String date = baseFunc.getElement(HOROSCOPE_DATE).getText();
       LOGGER.info(date);
       return date.replace(" ","");


    }

    public void openHoroscopeCharacteristicsPage() {
        baseFunc.getElement(DESCRIPTION_BUTTON).click();


    }
}
