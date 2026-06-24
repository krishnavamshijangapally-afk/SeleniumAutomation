package com.krishna.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.krishna.ecommerce.pages.TextBoxPage;
import com.krishna.ecommerce.utils.BaseTest;

public class TextBoxTest extends BaseTest {

	@Test(priority = 1)
	public void testTextBoxPageTitle() {
	    TextBoxPage textBoxPage = new TextBoxPage(driver);
	    textBoxPage.openPage();
	    try { Thread.sleep(3000); } catch (Exception e) {}
	    String title = textBoxPage.getPageTitle();
	    System.out.println("Page Title: " + title);
	    Assert.assertNotNull(title, "Title should not be null");
	    Assert.assertFalse(title.isEmpty(), "Title should not be empty");
	    System.out.println("✅ Title test PASSED!");
	}

    @Test(priority = 2)
    public void testFillTextBox() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.openPage();
        textBoxPage.enterFullName("Krishna Vamshi");
        textBoxPage.enterEmail("krishnavamshijangapally@gmail.com");
        textBoxPage.enterCurrentAddress("Hyderabad, Telangana, India");
        textBoxPage.enterPermanentAddress("Hyderabad, Telangana, India");
        textBoxPage.clickSubmit();

        boolean outputShown = textBoxPage.isOutputDisplayed();
        Assert.assertTrue(outputShown,
            "Output should be displayed after submit");
        System.out.println("✅ Form fill test PASSED!");
    }

    @Test(priority = 3)
    public void testOutputNameCorrect() {
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.openPage();
        textBoxPage.enterFullName("Krishna Vamshi");
        textBoxPage.enterEmail("krishnavamshijangapally@gmail.com");
        textBoxPage.enterCurrentAddress("Hyderabad, Telangana, India");
        textBoxPage.enterPermanentAddress("Hyderabad");
        textBoxPage.clickSubmit();

        String outputName = textBoxPage.getOutputName();
        System.out.println("Output Name: " + outputName);
        Assert.assertTrue(outputName.contains("Krishna Vamshi"),
            "Output should contain the name we entered");
        System.out.println("✅ Output name verification PASSED!");
    }
}