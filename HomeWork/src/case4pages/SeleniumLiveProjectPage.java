package case4pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Driver;

public class SeleniumLiveProjectPage {

    private WebDriver driver;

    public SeleniumLiveProjectPage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void acceptGdpr() {
    	driver.findElement(By.xpath("//iframe[not(@style='display: none;')]"));
		Driver.switchToFrame(By.xpath("//iframe[not(@style='display: none;')]"));
		driver.findElement(By.xpath("//button[@title='Accept']")).click();
		Driver.switchToParentFrame();
    }
    
    public boolean isPageHeaderDisplayed() {
    	return driver.findElement(By.xpath("//header/h1[text()='Selenium Live Project: FREE Real Time Project for Practice']")).isDisplayed();
    }
    
}
