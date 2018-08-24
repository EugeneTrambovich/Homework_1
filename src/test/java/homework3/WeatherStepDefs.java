package homework3;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homework3.model.Response;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WeatherStepDefs {
    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we getting weather from server")
    public void get_weather() {
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }

    @Then("visibility is (.*)")
    public void visibilityIs(Integer visibility) {

        assertEquals("Wrong visibility", visibility, response.getVisibility());
    }

    @Then("^weather id is (.*)")
    public void weatherIdIs(Integer id) {
        assertEquals("Wrong id", id, response.getWeather().get(0).getId());

    }
    @Then("^weather main is (.*)")
    public void weatherMainIs(String main) {
        assertEquals("Wrong main", main, response.getWeather().get(0).getMain());

    }
    @Then("^weather description is (.*)")
    public void weatherDescriptionIs(String description) {
        assertEquals("Wrong description", description, response.getWeather().get(0).getDescription());

    }
    @Then("^weather icon is (.*)")
    public void weatherIconIs(String icon) {
        assertEquals("Wrong icon", icon, response.getWeather().get(0).getIcon());

    }


    @Then("wind speed is (.*)")
    public void checkWindSpeed(BigDecimal windSpeed) {
        assertEquals("Wrong windSpeed", windSpeed, response.getWind().getSpeed());
    }

    @Then("wind deg is (.*)")
    public void checkWindDeg(Integer windDeg) {
        assertEquals("Wrong windDeg", windDeg, response.getWind().getDeg());
    }

    @Then("base is (.*)")
    public void checkBase(String base) {
        assertEquals("Wrong base", base, response.getBase());
    }

    @Then("temp is (.*)")
    public void checkMainTemp(BigDecimal mainTemp) {
        assertEquals("Wrong mainTemp", mainTemp, response.getMain().getTemp());
    }
    @Then("pressure is (.*)")
    public void checkMainPressure(Integer mainPressure) {
        assertEquals("Wrong mainPressure", mainPressure, response.getMain().getPressure());
    }
    @Then("humidity is (.*)")
    public void checkMainHumidity(Integer mainHumidity) {
        assertEquals("Wrong mainHumidity", mainHumidity, response.getMain().getHumidity());
    }
    @Then("temp_min is (.*)")
    public void checkMainTempMin(BigDecimal mainTemp_min) {
        assertEquals("Wrong mainTempMin", mainTemp_min, response.getMain().getTemp_min());
    }
    @Then("temp_max is (.*)")
    public void checkMainTempMax(BigDecimal mainTemp_max) {
        assertEquals("Wrong mainTempMax", mainTemp_max, response.getMain().getTemp_max());
    }

    @Then("dt is (.*)")
    public void checkDt(Integer dt) {
        assertEquals("Wrong dt", dt, response.getDt());
    }

    @Then("name is (.*)")
    public void checkName(String name) {
        assertEquals("Wrong name", name, response.getName());
    }

    @Then("id is (.*)")
    public void checkId(Integer id) {
        assertEquals("Wrong id", id, response.getId());
    }

    @Then("cod is (.*)")
    public void checkCod(Integer cod) {
        assertEquals("Wrong cod", cod, response.getCod());
    }

    @Then("all is (.*)")
    public void checkCloudsAll(Integer cloudsAll) {
        assertEquals("Wrong cloudsAll", cloudsAll, response.getClouds().getAll());
    }

    @Then("sys type is (.*)")
    public void checkSysType(Integer type) {
        assertEquals("Wrong sysType", type, response.getSys().getType());
    }

    @Then("sys id is (.*)")
    public void checkSysId(Integer id) {
        assertEquals("Wrong sysId", id, response.getSys().getId());
    }

    @Then("sys message is (.*)")
    public void checkSysMessage(BigDecimal message) {
        assertEquals("Wrong sysMessage", message, response.getSys().getMessage());
    }

    @Then("sys country is (.*)")
    public void checkSysCountry(String country) {
        assertEquals("Wrong sysCountry", country, response.getSys().getCountry());
    }

    @Then("sys sunrise is (.*)")
    public void checkSysSunrise(Integer sunrise) {
        assertEquals("Wrong sysSunrise", sunrise, response.getSys().getSunrise());
    }

    @Then("sys sunset is (.*)")
    public void checkSysSunset(Integer sunset) {
        assertEquals("Wrong sysSunset", sunset, response.getSys().getSunset());
    }
}
