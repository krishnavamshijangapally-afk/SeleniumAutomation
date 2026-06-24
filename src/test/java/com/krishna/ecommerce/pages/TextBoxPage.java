package com.krishna.ecommerce.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By fullNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By outputName = By.id("name");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openPage() {
        driver.get("https://demoqa.com/text-box");
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.out.println("✅ TextBox page opened!");
    }

    public void enterFullName(String name) {
        WebElement el = wait.until(
            ExpectedConditions.visibilityOfElementLocated(fullNameField));
        el.clear();
        el.sendKeys(name);
        System.out.println("✅ Name entered: " + name);
    }

    public void enterEmail(String email) {
        WebElement el = wait.until(
            ExpectedConditions.visibilityOfElementLocated(emailField));
        el.clear();
        el.sendKeys(email);
        System.out.println("✅ Email entered!");
    }

    public void enterCurrentAddress(String address) {
        WebElement el = wait.until(
            ExpectedConditions.visibilityOfElementLocated(currentAddressField));
        el.clear();
        el.sendKeys(address);
        System.out.println("✅ Address entered!");
    }

    public void enterPermanentAddress(String address) {
        WebElement el = wait.until(
            ExpectedConditions.visibilityOfElementLocated(permanentAddressField));
        el.clear();
        el.sendKeys(address);
        System.out.println("✅ Permanent address entered!");
    }

    public void clickSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn = driver.findElement(submitButton);
        js.executeScript("arguments[0].scrollIntoView(true);", btn);
        try { Thread.sleep(500); } catch (Exception e) {}
        btn.click();
        System.out.println("✅ Submit clicked!");
    }

    public boolean isOutputDisplayed() {
        try {
            return driver.findElement(outputName).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getOutputName() {
        try {
            return driver.findElement(outputName).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}