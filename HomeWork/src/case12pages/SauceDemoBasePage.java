package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Driver;

public class SauceDemoBasePage {

    private WebDriver driver;
    
    public SauceDemoBasePage() {
    	driver = Driver.getDriverInstance();
    }
    
    private WebElement footer() {
        return driver.findElement(By.cssSelector(".footer_copy"));
    }
    
	public String getFooterText() {
		return footer().getText();
	}
    
	public void scrollDownToFooter() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", footer());
		
	}
}
