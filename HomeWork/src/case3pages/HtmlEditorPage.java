package case3pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

public class HtmlEditorPage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public HtmlEditorPage() {
		driver = Driver.getDriverInstance();
		this.waitForEditor();
	}

	private WebElement loader() {
		return driver.findElement(By.className("spinner"));
	}

	private WebElement editorBody() {
		return driver.findElement(By.tagName("body"));
	}

	public void waitForEditor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(loader()));
	}

	public void insertHtmlCodeToEditor(String html) {
		js = (JavascriptExecutor) driver;
		Driver.switchToFrame(By.tagName("iframe"));
		js.executeScript(String.format("arguments[0].innerHTML = '%s'", html), editorBody());
		Driver.switchToParentFrame();
	}

	public String geteditorText() {
		Driver.switchToFrame(By.tagName("iframe"));
		String text = editorBody().getText();
		Driver.switchToParentFrame();
		return text;
	}
}
