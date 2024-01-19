package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends SauceDemoBasePage {

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private WebElement finishButton() {
        return driver.findElement(By.id("finish"));
    }
    
	public void clickOnFinishButton() {
		finishButton().click();
	}
	
}
