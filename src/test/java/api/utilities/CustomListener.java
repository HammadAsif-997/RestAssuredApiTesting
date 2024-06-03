package api.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class CustomListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Called before any test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Called after all tests finish
        generateReport(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Called when a test method starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Called when a test method is successful
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Called when a test method fails
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Called when a test method is skipped
    }

    @AfterClass
    private void generateReport(ITestContext context) {
        // Generate HTML report and save it to a specified folder
        String reportContent = "<html><body><h1>TestNG Report</h1><p>Custom HTML Report</p></body></html>";
        String reportPath = "reports/custom-report.html";
        // Write report content to file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(reportPath));
            writer.println(reportContent);
            writer.close();
            Reporter.log("HTML report generated at: " + reportPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}