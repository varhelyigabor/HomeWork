package case12pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends SauceDemoBasePage{
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private WebElement usernameInput() {
        return driver.findElement(By.id("user-name"));
    }
    private WebElement passwordInput() {
        return driver.findElement(By.id("password"));
    }
    private WebElement loginButton() {
        return driver.findElement(By.id("login-button"));
    }
    private WebElement errorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container"));
    }
    
    public void enterUsername(String username) {
    	usernameInput().sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	passwordInput().sendKeys(password);
    }
    
    public void clickLoginButton() {
    	loginButton().click();
    }

	public String getErrorMessage() {
		return errorMessage().getText();
	}
	
    public void login(String username, String password) {
    	enterUsername(username);
    	enterPassword(password);
    	clickLoginButton();
    }
}
