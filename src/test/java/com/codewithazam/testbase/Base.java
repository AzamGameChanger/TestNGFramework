package com.codewithazam.testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Base {

    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeTest(alwaysRun = true)
    public void generateReport() {
        htmlReporter = new ExtentHtmlReporter(Constants.REPORT_PATH);
        htmlReporter.config().setDocumentTitle("Report Title");
        htmlReporter.config().setReportName("Report Name");
        htmlReporter.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    }

    @AfterTest(alwaysRun = true)
    public void writeReport() {
        report.flush();

    }


    /**
     * This method will create the driver and return it.
     *
     * @return
     */
    @BeforeMethod(alwaysRun = true)
    public static WebDriver setUp() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        driver.manage().window().maximize();

        driver.get(ConfigsReader.getProperty("url"));

        return driver;
    }

    /**
     * This method will quit the browser
     */
    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
