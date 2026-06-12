package com.krishna.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    WebDriver driver;

    // Constructor
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Elements (locators)
    By searchBox = By.name("q");
    By searchButton = By.name("btnK");

    // Page Actions (methods)
    public void openGoogle() {
        driver.get("https://www.google.com");
    }

    public void searchFor(String keyword) {
        WebElement search = driver.findElement(searchBox);
        search.clear();
        search.sendKeys(keyword);
        search.submit();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}