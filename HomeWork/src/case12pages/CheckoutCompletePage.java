package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends SauceDemoBasePage {

    private WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }
    
    private WebElement orderWasSuccessfulMessage() {
        return driver.findElement(By.xpath("//div[@id='checkout_complete_container']//*[text()=('Thank you for your order!')]"));
    }
    
	public boolean isOrderSuccessful() {
		return orderWasSuccessfulMessage().isDisplayed();
	}
}
