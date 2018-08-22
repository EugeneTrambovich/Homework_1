package homework2;

import org.openqa.selenium.By;

public class HoroscopeCharecteristicsPage {

    private static final By HOROSCOPE_PLUSES_LOCATOR = By.xpath("//b[contains(text(), 'Plusi')]/..");
    private static final By HOROSCOPE_MINUSES_LOCATOR = By.xpath("//b[contains(text(), 'Mīnusi')]/..");
    private static final By HOROSCOPE_HAPPINESS_LOCATOR = By.xpath("//b[contains(text(), 'iepriecina')]/..");
    private static final By HOROSCOPE_ANNOYANCE_LOCATOR = By.xpath("//b[contains(text(), 'kaitina')]/..");

    private BaseFunc baseFunc;

    public HoroscopeCharecteristicsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getHoroscopePluses() {
        return baseFunc.getElement(HOROSCOPE_PLUSES_LOCATOR).getText();
    }

    public String getHoroscopeMinuses() {
        return baseFunc.getElement(HOROSCOPE_MINUSES_LOCATOR).getText();
    }

    public String getHoroscopeHappiness() {
        return baseFunc.getElement(HOROSCOPE_HAPPINESS_LOCATOR).getText();
    }

    public String getHoroscopeAnnoyance() {
        return baseFunc.getElement(HOROSCOPE_ANNOYANCE_LOCATOR).getText();
    }
}
