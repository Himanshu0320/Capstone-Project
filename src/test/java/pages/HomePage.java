package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By departureCity = By.name("fromPort");
    By destinationCity = By.name("toPort");
    By findFlights = By.cssSelector("input[type='submit']");

    public void searchFlight(String from, String to) {

        Select fromDropdown =
                new Select(driver.findElement(departureCity));

        fromDropdown.selectByVisibleText(from);

        Select toDropdown =
                new Select(driver.findElement(destinationCity));

        toDropdown.selectByVisibleText(to);

        driver.findElement(findFlights).click();
    }
}