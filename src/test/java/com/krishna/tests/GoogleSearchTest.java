package com.krishna.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.krishna.pages.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

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
    public void testGoogleOpens() {
        googlePage.openGoogle();
        String title = googlePage.getPageTitle();
        Assert.assertEquals(title, "Google");
        System.out.println("✅ Google opened! Title: " + title);
    }

    @Test(priority = 2)
    public void testSearchAutomationJobs() {
        googlePage.openGoogle();
        googlePage.searchFor("Automation Test Engineer jobs Hyderabad 2026");
        String url = googlePage.getCurrentUrl();
        Assert.assertTrue(url.contains("Automation"));
        System.out.println("✅ Search test passed!");
    }

    @Test(priority = 3)
    public void testSearchSelenium() {
        googlePage.openGoogle();
        googlePage.searchFor("Selenium WebDriver tutorial");
        String title = googlePage.getPageTitle();
        Assert.assertTrue(title.contains("Selenium"));
        System.out.println("✅ Selenium search passed!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Browser closed!");
    }
}