package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            try {

                // Create test-output folder if it doesn't exist
                File reportDir = new File("test-output");

                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                String reportPath = "test-output/ExtentReport.html";

                System.out.println("Creating Extent Report at: "
                        + new File(reportPath).getAbsolutePath());

                ExtentSparkReporter spark =
                        new ExtentSparkReporter(reportPath);

                spark.config().setReportName("BlazeDemo Automation Report");
                spark.config().setDocumentTitle("Execution Report");

                extent = new ExtentReports();
                extent.attachReporter(spark);

                extent.setSystemInfo("Tester", "Himanshu Sharma");
                extent.setSystemInfo("Framework", "Selenium + TestNG");
                extent.setSystemInfo("Project", "BlazeDemo Automation");

                System.out.println("Extent Report initialized successfully.");

            } catch (Exception e) {

                System.out.println("Failed to create Extent Report");
                e.printStackTrace();
            }
        }

        return extent;
    }
}