package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.WaitUtils;

public class TestFlightSearch extends BaseTest {

    @Test
    public void flightSearchTest() {

        driver.get("https://blazedemo.com/"); // VERY IMPORTANT

        utilities.WaitUtils wait = new utilities.WaitUtils(driver, 10);

        // FROM dropdown
        WebElement from = wait.waitForVisibility(By.name("fromPort"));
        Select fromSelect = new Select(from);
        fromSelect.selectByVisibleText("Portland");

        // TO dropdown
        WebElement to = wait.waitForVisibility(By.name("toPort"));
        Select toSelect = new Select(to);
        toSelect.selectByVisibleText("London");

        // CLICK search
        WebElement searchBtn = wait.waitForClickability(By.cssSelector("input[type='submit']"));
        searchBtn.click();
    }
}