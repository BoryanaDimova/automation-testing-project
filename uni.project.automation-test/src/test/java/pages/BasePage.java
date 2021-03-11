package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
	protected WebDriver webDriver;
	public static final String BASE_URL ="https://www.calculator.bg/";
	
	public BasePage(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage openHomePage() {
		webDriver.navigate().to(BASE_URL);
		return new HomePage(webDriver);
	} 
	
	protected String getFieldValue(WebElement element) {
		return element.getAttribute("value");
	}
}