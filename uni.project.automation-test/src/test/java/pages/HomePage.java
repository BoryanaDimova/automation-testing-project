package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public KonventorPage navigateToKonventorPage() {
		webDriver.navigate().to(BASE_URL + "2/konvertor.html");
		return new KonventorPage(webDriver);
	}

}
