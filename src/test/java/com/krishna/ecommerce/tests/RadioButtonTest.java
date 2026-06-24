package com.krishna.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.krishna.ecommerce.pages.RadioButtonPage;
import com.krishna.ecommerce.utils.BaseTest;

public class RadioButtonTest extends BaseTest {

	@Test(priority = 1)
	public void testRadioButtonPageOpens() {
	    RadioButtonPage radioPage = new RadioButtonPage(driver);
	    radioPage.openPage();
	    try { Thread.sleep(2000); } catch (Exception e) {}
	    String title = radioPage.getPageTitle();
	    System.out.println("Page Title: " + title);
	    Assert.assertFalse(title.isEmpty(), "Page should load!");
	    System.out.println("✅ Radio Button page open test PASSED!");
	}

    @Test(priority = 2)
    public void testSelectYesRadioButton() {
        RadioButtonPage radioPage = new RadioButtonPage(driver);
        radioPage.openPage();
        radioPage.selectYes();

        try { Thread.sleep(1000); } catch (Exception e) {}

        String result = radioPage.getSelectedText();
        System.out.println("Selected: " + result);
        Assert.assertEquals(result, "Yes",
            "Selected text should be Yes");
        System.out.println("✅ Yes radio button test PASSED!");
    }

    @Test(priority = 3)
    public void testSelectImpressiveRadioButton() {
        RadioButtonPage radioPage = new RadioButtonPage(driver);
        radioPage.openPage();
        radioPage.selectImpressive();

        try { Thread.sleep(1000); } catch (Exception e) {}

        String result = radioPage.getSelectedText();
        System.out.println("Selected: " + result);
        Assert.assertEquals(result, "Impressive",
            "Selected text should be Impressive");
        System.out.println("✅ Impressive radio button test PASSED!");
    }
}