package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.JsonReportUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("=== TEST EXECUTION STARTED ===");
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("=== TEST STARTED: "
                + result.getMethod().getMethodName());

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

        JsonReportUtil.writeResult(
                result.getMethod().getMethodName(),
                "PASS");

        System.out.println("=== TEST PASSED ===");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().fail(result.getThrowable());

        JsonReportUtil.writeResult(
                result.getMethod().getMethodName(),
                "FAIL");

        System.out.println("=== TEST FAILED ===");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        JsonReportUtil.writeResult(
                result.getMethod().getMethodName(),
                "SKIPPED");

        System.out.println("=== TEST SKIPPED ===");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("=== FLUSHING EXTENT REPORT ===");

        extent.flush();

        System.out.println("=== EXECUTION COMPLETED ===");
    }
}