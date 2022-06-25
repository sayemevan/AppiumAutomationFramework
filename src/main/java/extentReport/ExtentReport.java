package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtentReport {
    static ExtentReports extent;
    final static String filePath = "Extent.html";
    static Map<Integer, ExtentTest> extentTestMap = new HashMap();

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {

            ExtentSparkReporter html = new ExtentSparkReporter("TestReport" + File.separator +"Extent.html");
            html.config().setDocumentTitle("Appium Android App Testing");
            html.config().setReportName("Md. Sayem Sikder");
            html.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(html);

        }
        return extent;
    }
    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getReporter().createTest(testName, desc);
        extentTestMap.put((int) (Thread.currentThread().getId()), test);
        return test;
    }
}