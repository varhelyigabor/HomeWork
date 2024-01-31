package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends SauceDemoBasePage {

    public CheckoutOverviewPage() {
        super();
    }
    
    private WebElement finishButton() {
        return driver.findElement(By.id("finish"));
    }
    
	public void clickOnFinishButton() {
		finishButton().click();
	}
	
}
