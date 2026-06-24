package com.krishna.ecommerce.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.out.println("========================================");
        System.out.println("   KRISHNA VAMSHI - BROWSER STARTING");
        System.out.println("========================================");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("✅ Browser launched successfully!");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File screenshot = ts.getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat(
                    "yyyy-MM-dd_HH-mm-ss").format(new Date());
                String testName = result.getName();
                String path = "screenshots/ecommerce/"
                    + testName + "_" + timestamp + ".png";
                new File("screenshots/ecommerce").mkdirs();
                FileUtils.copyFile(screenshot, new File(path));
                System.out.println("📸 Screenshot: " + path);
            } catch (IOException e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed!");
        }
        System.out.println("========================================");
        System.out.println("   TEST CLASS COMPLETED!");
        System.out.println("========================================");
    }
}