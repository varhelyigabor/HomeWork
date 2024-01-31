package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YourCartPage extends SauceDemoBasePage {

    public YourCartPage() {
    	super();
    }
    
    private WebElement checkOutButton() {
        return driver.findElement(By.id("checkout"));
    }
    
	public void clickOnCheckoutButton() {
		checkOutButton().click();
	}
}
