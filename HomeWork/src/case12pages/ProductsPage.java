package case12pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductsPage extends SauceDemoBasePage {

	public ProductsPage() {
        super();
    }

    private WebElement cartIcon() {
        return driver.findElement(By.id("shopping_cart_container"));
    }
    
    public void addToCart(String productName) {
    	driver.findElement(By.xpath("//div[@class='inventory_item' and descendant::div[contains(@class, 'inventory_item_name') and text()='" + productName + "']]//div[@class='pricebar']/button")).click();
    }
    
    public int getCartCount() {
    	int elementExists = driver.findElements(By.cssSelector(".shopping_cart_badge")).size();
    	if (elementExists == 0)
    	{
    		return 0;
    	}
    	else
    	{
    		return Integer.valueOf(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText());
    	}

    }

	public void openCart() {
		cartIcon().click();
	}

}