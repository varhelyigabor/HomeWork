package uiTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import case12pages.Pages;
import case3pages.HtmlEditorPage;
import case4pages.Guru99Page;
import case4pages.SeleniumLiveProjectPage;
import models.Credentials;
import utils.Driver;
import utils.JsonReader;

public class UITests {

	WebDriver driver;
	Pages pages;
	
	@BeforeTest
	public void setup() {
		driver = Driver.getDriverInstance();
	    driver.manage().window().maximize();
	    pages = new Pages();
	}
	
	@AfterTest
	public void teardown() {
		Driver.closeDriver();
	}
	
	@Test
	public void case1_test() {
	
		Credentials user = JsonReader.getCredentials();
		Driver.openUrl("https://www.saucedemo.com/");
		pages.onLoginPage().login(user.username, user.password);

		pages.onProductsPage().addToCart("Sauce Labs Backpack");
		pages.onProductsPage().addToCart("Sauce Labs Fleece Jacket");
		Assert.assertEquals(pages.onProductsPage().getCartCount(), 2, "Cart count symbol should show 2.");

		pages.onProductsPage().openCart();
		pages.onYourCartPage().clickOnCheckoutButton();

		pages.onCheckoutInformationPage().fillCustomerData("Test", "User", "1111");
		pages.onCheckoutInformationPage().clickOnContinueButton();

		pages.onCheckoutOverviewPage().clickOnFinishButton();

		Assert.assertTrue(pages.onCheckoutCompletePage().isOrderSuccessful());

	}
	
	@Test
	public void case2_test() {

		Driver.openUrl("https://www.saucedemo.com/");
		pages.onLoginPage().clickLoginButton();

		Assert.assertEquals(pages.onLoginPage().getErrorMessage(), "Epic sadface: Username is required");
		pages.onLoginPage().login("standard_user", "secret_sauce");

		pages.onProductsPage().scrollDownToFooter();

		Assert.assertTrue(pages.onProductsPage().getFooterText().contains("2024"));
		Assert.assertTrue(pages.onProductsPage().getFooterText().contains("Terms of Service"));

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
