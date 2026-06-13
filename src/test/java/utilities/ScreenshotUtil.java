package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String screenshotPath =
                "screenshots/" +
                testName + "_" +
                timestamp + ".png";

        try {

            File srcFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File destFile =
                    new File(screenshotPath);

            destFile.getParentFile().mkdirs();

            FileHandler.copy(srcFile, destFile);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return screenshotPath;
    }
}