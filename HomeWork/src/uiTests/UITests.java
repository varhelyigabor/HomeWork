package uiTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import case12pages.CheckoutCompletePage;
import case12pages.CheckoutInformationPage;
import case12pages.CheckoutOverviewPage;
import case12pages.LoginPage;
import case12pages.ProductsPage;
import case12pages.YourCartPage;
import case3pages.HtmlEditorPage;
import case4pages.Guru99Page;
import case4pages.SeleniumLiveProjectPage;
import models.Credentials;
import utils.Driver;
import utils.JsonReader;

public class UITests {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = Driver.getDriverInstance();
	    driver.manage().window().maximize();
	}
	
	@AfterTest
	public void teardown() {
		Driver.closeDriver();
	}
	
	@Test
	public void case1_test() {
	
		Credentials user = JsonReader.getCredentials();
		Driver.openUrl("https://www.saucedemo.com/");
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(user.username, user.password);
		
	    ProductsPage productsPage = new ProductsPage(driver);
	    productsPage.addToCart("Sauce Labs Backpack");
	    productsPage.addToCart("Sauce Labs Fleece Jacket");
	    
	    Assert.assertEquals(productsPage.getCartCount(), 2, "Cart count symbol should show 2.");
	
	    productsPage.openCart();
	    YourCartPage yourCartPage = new YourCartPage(driver);
	    yourCartPage.clickOnCheckoutButton();
	    
	    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver); 
	    checkoutInformationPage.fillCustomerData("Test", "User", "1111");
	    checkoutInformationPage.clickOnContinueButton();
	    
	    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver); 
	    checkoutOverviewPage.clickOnFinishButton();
	    
	    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
	    Assert.assertTrue(checkoutCompletePage.isOrderSuccessful());

	}
	
	@Test
	public void case2_test() {
		
		Driver.openUrl("https://www.saucedemo.com/");    
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.clickLoginButton();
	    
	    Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
	    loginPage.login("standard_user", "secret_sauce");
	    
	    ProductsPage productsPage = new ProductsPage(driver);
        productsPage.scrollDownToFooter();
	    
	    Assert.assertTrue(productsPage.getFooterText().contains("2024"));
	    Assert.assertTrue(productsPage.getFooterText().contains("Terms of Service"));
	    
	}
	
	@Test
	public void case3_test() {
	    
		Driver.openUrl("https://onlinehtmleditor.dev");
		HtmlEditorPage htmlEditorPage = new HtmlEditorPage();
		htmlEditorPage.insertHtmlCodeToEditor("<p><strong>Automation </strong><u>Test</u> Example</p>");
		Assert.assertEquals(htmlEditorPage.geteditorText(), "Automation Test Example");

	}
	
	@Test
	public void case4_new_tab() {
		
		Driver.openUrl("http://demo.guru99.com/test/guru99home");
	    Guru99Page gurupage = new Guru99Page(driver);
		gurupage.acceptGdpr();
	    
	    String originalWindow = driver.getWindowHandle();
	    
	    gurupage.clickOnAdToOpenSeleniumLiveProjectPage();

	    Driver.switchContolToNewTab(originalWindow);

		SeleniumLiveProjectPage seleniumLiveProjectPage = new SeleniumLiveProjectPage(driver);
		seleniumLiveProjectPage.acceptGdpr();
		Assert.assertTrue(seleniumLiveProjectPage.isPageHeaderDisplayed());
		
		
		Driver.closeTab();
		Driver.switchTabControl(originalWindow);

		gurupage.closeAdIfPresent();
		
		gurupage.selectMenuItem("Testing/Selenium");
		gurupage.closeAdIfPresent();

	          
	}
}
