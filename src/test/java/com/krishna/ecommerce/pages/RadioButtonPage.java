package com.krishna.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.krishna.ecommerce.utils.BasePage;

public class RadioButtonPage extends BasePage {

    private static final String URL = "https://demoqa.com/radio-button";

    private By yesRadioButton = By.cssSelector("label[for='yesRadio']");
    private By impressiveRadioButton = By.cssSelector("label[for='impressiveRadio']");
    private By successText = By.className("text-success");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://demoqa.com/radio-button");
        try { Thread.sleep(2000); } catch (Exception e) {}
        System.out.println("✅ Radio Button page opened!");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void selectYes() {
        clickElement(yesRadioButton);
        System.out.println("✅ Yes selected!");
    }

    public void selectImpressive() {
        clickElement(impressiveRadioButton);
        System.out.println("✅ Impressive selected!");
    }

    public String getSelectedText() {
        return getText(successText);
    }
}