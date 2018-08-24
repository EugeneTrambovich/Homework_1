package homework2version2;

import homework2.BaseFunc;
import org.openqa.selenium.By;

public class DelfiHomePage {

    private final static By HOROSCOPE_PAGE_LOCATOR = By.linkText("Horoskopi");

    private BaseFunc baseFunc;

    public DelfiHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHoroscopePage() {
        baseFunc.getElement(HOROSCOPE_PAGE_LOCATOR).click();
    }
}
