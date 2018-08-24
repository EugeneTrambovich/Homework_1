package homework2version2;

import homework2.BaseFunc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HoroscopePageObjectTest {
    private BaseFunc baseFunc;
    private final String DELFI_PAGE = "http://www.delfi.lv/";

    @Before
    public void setUp() {
        baseFunc = new BaseFunc();
    }

    @After
    public void tearDown() {
        baseFunc.closeBrowser();
    }

    @Test
    public void testAllHoroscopes() {
        baseFunc.openPage(DELFI_PAGE);

        DelfiHomePage delfiHomePage = new DelfiHomePage(baseFunc);
        delfiHomePage.openHoroscopePage();
        HoroscopeHomePage horoscopeHomePage = new HoroscopeHomePage(baseFunc);

        List<HoroscopeHomePage.OneHoroscope> allHoroscopes = horoscopeHomePage.getAllHoroscopes();

        for (HoroscopeHomePage.OneHoroscope oneHoroscope : allHoroscopes) {
            oneHoroscope.openHoroscope();
            testHoroscope(oneHoroscope.getHoroscopeName(), oneHoroscope.getHoroscopeDate());
        }

    }

    private void testHoroscope(String horoscopeName, String horoscopeDate) {

        HoroscopeDetailPage horoscopeDetailPage = new HoroscopeDetailPage(baseFunc);
        String dateFromDetailPage = horoscopeDetailPage.getHoroscopeDate();
        assertTrue(dateFromDetailPage.contains(horoscopeDate));
        assertEquals(horoscopeName, horoscopeDetailPage.getHoroscopeName());
        horoscopeDetailPage.openHoroscopeCharacteristicsPage();

        HoroscopeCharecteristicsPage charecteristicsPage = new HoroscopeCharecteristicsPage(baseFunc);
        assertFalse("Horoscope annoyance not found", charecteristicsPage.getHoroscopeAnnoyance().isEmpty());
        assertFalse("Horoscope happiness not found", charecteristicsPage.getHoroscopeHappiness().isEmpty());
        assertFalse("Horoscope pluses not found", charecteristicsPage.getHoroscopePluses().isEmpty());
        assertFalse("Horoscope minuses not found", charecteristicsPage.getHoroscopeMinuses().isEmpty());

        charecteristicsPage.openHoroscopeHomePage();
    }
}
