package case12pages;

public class Pages {

	private CheckoutCompletePage checkoutCompletePage;
	private CheckoutInformationPage checkoutInformationPage;
	private CheckoutOverviewPage checkoutOverviewPage;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private YourCartPage yourCartPage;

	public Pages() {
		this.checkoutCompletePage = new CheckoutCompletePage();
		this.checkoutInformationPage = new CheckoutInformationPage();
		this.checkoutOverviewPage = new CheckoutOverviewPage();
		this.loginPage = new LoginPage();
		this.productsPage = new ProductsPage();
		this.yourCartPage = new YourCartPage();
	}

	public LoginPage onLoginPage() {
		return this.loginPage;
	}

	public ProductsPage onProductsPage() {
		return this.productsPage;
	}

	public YourCartPage onYourCartPage() {
		return this.yourCartPage;
	}

	public CheckoutCompletePage onCheckoutCompletePage() {
		return this.checkoutCompletePage;
	}

	public CheckoutInformationPage onCheckoutInformationPage() {
		return this.checkoutInformationPage;
	}

	public CheckoutOverviewPage onCheckoutOverviewPage() {
		return this.checkoutOverviewPage;
	}

}
