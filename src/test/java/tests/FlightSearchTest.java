package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utilities.ConfigReader;

public class FlightSearchTest extends BaseTest {

    @Test
    public void searchFlightTest() {

        driver.get(ConfigReader.getProperty("url"));

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight(
                ConfigReader.getProperty("departure"),
                ConfigReader.getProperty("destination"));

        Assert.assertTrue(
                driver.getPageSource().contains(
                        "Flights from Boston to London:"),
                "Flight search failed!");
    }
}