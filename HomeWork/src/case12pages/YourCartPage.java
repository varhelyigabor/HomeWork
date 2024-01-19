package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage extends SauceDemoBasePage {

    private WebDriver driver;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private WebElement checkOutButton() {
        return driver.findElement(By.id("checkout"));
    }
    
	public void clickOnCheckoutButton() {
		checkOutButton().click();
	}
}
