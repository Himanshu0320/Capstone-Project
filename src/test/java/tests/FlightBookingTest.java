package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtils;
import utilities.WaitUtils;

public class FlightBookingTest extends BaseTest {

    @DataProvider(name = "flightData")
    public Object[][] getData() {
        return ExcelUtils.getTestData(
                "src/test/resources/PassengerData.xlsx",
                "PassengerData"
        );
    }

    @Test(dataProvider = "flightData")
    public void bookFlight(String name, String address, String city, String state, String zip,String card, String cardNumber, String month, String year, String cardHolderName) {

        driver.get("https://blazedemo.com/");

        WaitUtils wait = new WaitUtils(driver, 10);

        // Flight search
        wait.waitForVisibility(By.name("fromPort")).sendKeys("Portland");
        wait.waitForVisibility(By.name("toPort")).sendKeys("London");

        wait.waitForClickability(By.cssSelector("input[type='submit']")).click();

        // Select flight
        wait.waitForClickability(By.xpath("//input[contains(@value,'Choose This Flight')]")).click();

        // Booking form (NOW FROM EXCEL)
        wait.waitForVisibility(By.id("inputName")).sendKeys(name);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("address")).sendKeys(address);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("city")).sendKeys(city);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("state")).sendKeys(state);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("zipCode")).sendKeys(zip);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("cardType")).sendKeys(card);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("creditCardNumber")).sendKeys(cardNumber);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("creditCardMonth")).clear();
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("creditCardMonth")).sendKeys(month);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("creditCardYear")).clear();
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("creditCardYear")).sendKeys(year);
        wait.slowDown(1000);
        wait.waitForVisibility(By.id("nameOnCard")).sendKeys(cardHolderName);
        wait.slowDown(1000);
        

        wait.waitForClickability(By.cssSelector("input[type='submit']")).click();

        // Screenshot (optional if you added earlier)
        wait.takeScreenshot(name + "_booking");
    }
}