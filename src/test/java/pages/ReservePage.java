package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {

    WebDriver driver;

    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFlight =
            By.xpath("(//input[@value='Choose This Flight'])[1]");

    public void selectFlight() {

        driver.findElement(chooseFlight)
              .click();
    }
}