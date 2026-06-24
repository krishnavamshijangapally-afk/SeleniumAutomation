package com.krishna.ecommerce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Wait for page to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    // Wait for element and click
    protected void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Clicked: " + locator);
    }

    // Wait for element and type text
    protected void typeText(By locator, String text) {
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        System.out.println("Typed: " + text);
    }

    // Get text from element
    protected String getText(By locator) {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Check if element is displayed
    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Scroll to element
    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", element);
        System.out.println("Scrolled to element: " + locator);
    }

    // Get page title
    protected String getPageTitle() {
        return driver.getTitle();
    }

    // Navigate to URL
    protected void navigateTo(String url) {
        driver.get(url);
        System.out.println("Navigated to: " + url);
    }
}