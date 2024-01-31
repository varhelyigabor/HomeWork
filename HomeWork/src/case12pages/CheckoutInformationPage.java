package case12pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage extends SauceDemoBasePage {

	public CheckoutInformationPage() {
		super();
	}

	private WebElement firstNameInput() {
		return driver.findElement(By.id("first-name"));
	}

	private WebElement lastNameInput() {
		return driver.findElement(By.id("last-name"));
	}

	private WebElement zipCodeInput() {
		return driver.findElement(By.id("postal-code"));
	}

	private WebElement continueButton() {
		return driver.findElement(By.id("continue"));
	}

	public void fillCustomerData(String firstName, String lastName, String zipCode) {
		firstNameInput().sendKeys(firstName);
		lastNameInput().sendKeys(lastName);
		zipCodeInput().sendKeys(zipCode);
	}

	public void clickOnContinueButton() {
		continueButton().click();
	}

}
