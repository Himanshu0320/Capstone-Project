package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Required for Jenkins
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            // Required for Jenkins
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);

        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
