package com.krishna.ecommerce.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://demoqa.com/checkbox";

    private By expandButton = By.cssSelector("button[aria-label='Expand all']");
    private By homeCheckBox = By.cssSelector("label[@for='tree-node-home']");
    private By resultBox = By.id("result");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openPage() {
        driver.get(URL);
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.out.println("✅ CheckBox page opened!");
    }

    public void expandAll() {
        try {
            WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(expandButton));
            btn.click();
            Thread.sleep(1000);
            System.out.println("✅ Expanded all checkboxes!");
        } catch (Exception e) {
            System.out.println("Expand button issue: " + e.getMessage());
        }
    }

    public void selectHomeCheckBox() {
        try {
            WebElement chk = wait.until(
                ExpectedConditions.elementToBeClickable(homeCheckBox));
            chk.click();
            Thread.sleep(1000);
            System.out.println("✅ Home checkbox selected!");
        } catch (Exception e) {
            System.out.println("Checkbox issue: " + e.getMessage());
        }
    }

    public boolean isResultDisplayed() {
        try {
            Thread.sleep(1000);
            return driver.findElement(resultBox).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getResult() {
        try {
            return driver.findElement(resultBox).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}