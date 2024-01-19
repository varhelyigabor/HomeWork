package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Driver {

	    private static WebDriver driver;

	    private Driver() {
	    }

	    public static WebDriver getDriverInstance() {
	        if (driver == null) {
	    		System.setProperty("webdriver.chrome.driver",
	    				System.getProperty("user.dir") + "\\src\\drivers\\chromedriver.exe");  
	    	    driver = new ChromeDriver();
	        }
	        return driver;
	    }

	    public static void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	    
	    public static void switchToFrame(By by) {
	    	driver.switchTo().frame(driver.findElement(by));
	    }
	    
	    public static void switchToParentFrame() {
	    	driver.switchTo().parentFrame();
	    }
	    
	    public static void hoverOver(WebElement element) {
	        Actions actions = new Actions(getDriverInstance());
	        actions.moveToElement(element).perform();
	    }
	    
	    public static void switchContolToNewTab(String originalWindow) {
			for (String windowHandle : driver.getWindowHandles()) {
			    if(!originalWindow.contentEquals(windowHandle)) {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}
	    }
	    
	    public static void switchTabControl(String window) {
	    	driver.switchTo().window(window);
	    }

		public static void openUrl(String url) {
			driver.navigate().to(url); 
		}

		public static void closeTab() {
			driver.close();
		}
	    
}
