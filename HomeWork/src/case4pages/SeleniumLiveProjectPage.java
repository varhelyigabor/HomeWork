package case4pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Driver;

public class SeleniumLiveProjectPage {

	private WebDriver driver;

	public SeleniumLiveProjectPage(WebDriver driver) {
		this.driver = driver;
	}

	public void acceptGdpr() {
		Driver.switchToFrame(By.xpath("//iframe[not(@style='display: none;')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Accept']")));
		driver.findElement(By.xpath("//button[@title='Accept']")).click();
		Driver.switchToParentFrame();
	}

	public boolean isPageHeaderDisplayed() {
		return driver.findElement(By.xpath("//header/h1[text()='Selenium Live Project: FREE Real Time Project for Practice']")).isDisplayed();
	}

}
