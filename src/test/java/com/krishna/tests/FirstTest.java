package com.krishna.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

    WebDriver driver;

    // Runs BEFORE every test — sets up browser
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("✅ Browser opened!");
    }

    // This is the actual TEST
    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // ASSERTION — checks if title is correct!
        Assert.assertEquals(title, "Google");
        System.out.println("✅ Title test PASSED!");
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Automation Test Engineer jobs Hyderabad");
        searchBox.submit();

        String pageTitle = driver.getTitle();
        System.out.println("Search Title: " + pageTitle);

        // Check if search results loaded
        Assert.assertTrue(pageTitle.contains("Automation"));
        System.out.println("✅ Search test PASSED!");
    }

    // Runs AFTER every test — closes browser
    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Browser closed!");
    }
}
    
    
