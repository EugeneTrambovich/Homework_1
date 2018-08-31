package homework2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HoroscopePageObjectTest {
   
    private BaseFunc baseFunc;
    private final String HOROSCOPE_PAGE = "http://www.delfi.lv/orakuls/horoskopi/";

    @Before
    public void setUp() {
        baseFunc = new BaseFunc();
    }

    @After
    public void tearDown() {
        baseFunc.closeBrowser();
    }

    @Test
    public void piscesPageTest() {
        testHoroscope("Zivis", "19.februāris–20.marts");
    }

    @Test
    public void aquariusPageTest() {
        testHoroscope("Ūdensvīrs", "20.janvāris–18.februāris");
    }

    @Test
    public void capricornPageTest() {
        testHoroscope("Mežāzis", "21.decembris–19.janvāris");
    }

    @Test
    public void sagittariusPageTest() {
        testHoroscope("Strēlnieks", "23.novembris–20.decembris");
    }

    @Test
    public void scorpionPageTest() {
        testHoroscope("Skorpions", "23.oktobris–22.novembris");
    }

    @Test
    public void libraPageTest() {
        testHoroscope("Svari", "23.septembris–22.oktobris");
    }

    @Test
    public void virgoPageTest() {
        testHoroscope("Jaunava", "22.augusts–22.septembris");
    }

    @Test
    public void lionPageTest() {
        testHoroscope("Lauva", "21.jūlijs–21.augusts");
    }

    @Test
    public void cancerPageTest() {
        testHoroscope("Vēzis", "21.jūnijs–20.jūlijs");
    }

    @Test
    public void geminiPageTest() { testHoroscope("Dvīņi", "21.maijs–20.jūnijs"); }

    @Test
    public void taurusPageTest() { testHoroscope("Vērsis", "21.aprīlis–20.maijs"); }



    @Test
    public void ariesPageTest() {
        testHoroscope("Auns", "21.marts–20.aprīlis");
    }


    private void testHoroscope(String horoscopeName, String horoscopeDate) {
        baseFunc.openPage(HOROSCOPE_PAGE);

        
        HoroscopeHomePage homePage = new HoroscopeHomePage(baseFunc);
        String dateFromHomePage = homePage.getHoroscopeDate(horoscopeName);
        assertEquals(horoscopeDate, dateFromHomePage);
        homePage.openHoroscopePage(horoscopeName);

        HoroscopeDetailPage horoscopeDetailPage = new HoroscopeDetailPage(baseFunc);
        String dateFromDetailPage = horoscopeDetailPage.getHoroscopeDate();
        assertTrue(dateFromDetailPage.contains(horoscopeDate));
        horoscopeDetailPage.openHoroscopeCharacteristicsPage();

        HoroscopeCharecteristicsPage charecteristicsPage = new HoroscopeCharecteristicsPage(baseFunc);
        assertFalse("Horoscope annoyance not found", charecteristicsPage.getHoroscopeAnnoyance().isEmpty());
        assertFalse("Horoscope happiness not found", charecteristicsPage.getHoroscopeHappiness().isEmpty());
        assertFalse("Horoscope pluses not found", charecteristicsPage.getHoroscopePluses().isEmpty());
        assertFalse("Horoscope minuses not found", charecteristicsPage.getHoroscopeMinuses().isEmpty());


    }
}
