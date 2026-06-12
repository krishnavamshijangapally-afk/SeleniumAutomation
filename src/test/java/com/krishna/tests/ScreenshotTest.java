package com.krishna.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.krishna.pages.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTest {

    WebDriver driver;
    GooglePage googlePage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        googlePage = new GooglePage(driver);
        System.out.println("✅ Browser ready!");
    }

    @Test(priority = 1)
    public void testGoogleTitle() {
        googlePage.openGoogle();
        String title = googlePage.getPageTitle();
        Assert.assertEquals(title, "Google");
        System.out.println("✅ Title test PASSED!");
    }

    // This test will FAIL on purpose — to show screenshot!
    @Test(priority = 2)
    public void testWrongTitle() {
        googlePage.openGoogle();
        String title = googlePage.getPageTitle();
        // Wrong expected value on purpose!
        Assert.assertEquals(title, "Facebook");
        System.out.println("This won't print — test fails!");
    }

    @Test(priority = 3)
    public void testSearchWorks() {
        googlePage.openGoogle();
        googlePage.searchFor("Selenium jobs Hyderabad");
        String url = googlePage.getCurrentUrl();
        Assert.assertTrue(url.contains("Selenium"));
        System.out.println("✅ Search test PASSED!");
    }

    // Runs after EACH test method
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
            	
                // Take screenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                File screenshot = ts.getScreenshotAs(OutputType.FILE);

                // Create filename with timestamp
                String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
                String testName = result.getName();
                String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

                // Save screenshot
                FileUtils.copyFile(screenshot, new File(filePath));
                System.out.println("📸 Screenshot saved: " + filePath);

            } catch (IOException e) {
                System.out.println("❌ Screenshot failed: " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Browser closed!");
    }
}