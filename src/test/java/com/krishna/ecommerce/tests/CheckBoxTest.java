package com.krishna.ecommerce.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.krishna.ecommerce.pages.CheckBoxPage;
import com.krishna.ecommerce.utils.BaseTest;

public class CheckBoxTest extends BaseTest {

    @Test(priority = 1)
    public void testCheckBoxPageOpens() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.openPage();
        String title = checkBoxPage.getPageTitle();
        System.out.println("Page Title: " + title);
        Assert.assertFalse(title.isEmpty(), "Page should load!");
        System.out.println("✅ CheckBox page open test PASSED!");
    }

    @Test(priority = 2)
    public void testCheckBoxURLCorrect() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.openPage();
        try { Thread.sleep(2000); } catch (Exception e) {}
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);
        Assert.assertTrue(url.contains("demoqa.com"),
            "URL should contain demoqa.com");
        System.out.println("✅ CheckBox URL test PASSED!");
    }

    @Test(priority = 3)
    public void testCheckBoxPageBodyLoaded() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.openPage();
        try { Thread.sleep(2000); } catch (Exception e) {}
        // Check page body is not empty
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertFalse(bodyText.isEmpty(),
            "Page body should have content!");
        System.out.println("Body has content: " + bodyText.length() + " chars");
        System.out.println("✅ CheckBox page loaded test PASSED!");
    }
}