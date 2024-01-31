package case4pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class Guru99Page {
	private WebDriver driver;

	public Guru99Page(WebDriver driver) {
		this.driver = driver;
	}

	private String menuitemSelector = "//div[@class='menu-block']//a[@class='item' and normalize-space()='%s']";

	private By adIframeLocator = By
			.xpath("//iframe[(@title='Advertisement' or @aria-label='Advertisement') and contains(@id, 'ads_iframe')]");

	private WebElement acceptGdprButton() {
		return driver.findElement(By.xpath("//app-footer//button[@id='save']"));
	}

	public void closeAdIfPresent() {
		if (driver.findElements(adIframeLocator).size() > 0 && driver.findElement(adIframeLocator).isDisplayed()) {
			Driver.switchToFrame(adIframeLocator);
			driver.findElement(By.xpath("//span[text()='Close'] | //div[@id='dismiss-button']")).click();
			driver.switchTo().parentFrame();
		}
	}

	public void acceptGdpr() {
		Driver.switchToFrame(By.xpath("//iframe[@id='gdpr-consent-notice']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(acceptGdprButton()));
		acceptGdprButton().click();
		Driver.switchToParentFrame();
	}

	public void clickOnAdToOpenSeleniumLiveProjectPage() {
		Driver.switchToFrame(By.xpath("//iframe[@id='a077aa5e']"));
		Driver.getDriverInstance().findElement(By.tagName("body")).click();
		Driver.switchToParentFrame();
	}

	public void selectMenuItem(String path) {
		String[] menuitems = path.split("/");
		if (menuitems.length == 1) {
			driver.findElement(By.xpath(String.format(menuitemSelector, menuitems[0]))).click();
		} else if (menuitems.length == 2) {
			Driver.hoverOver(driver.findElement(By.xpath(String.format(menuitemSelector, menuitems[0]))));
			driver.findElement(By.xpath(String.format(menuitemSelector, menuitems[1]))).click();
		}

	}

}
