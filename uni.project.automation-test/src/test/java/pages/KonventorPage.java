package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KonventorPage extends HomePage{

	public KonventorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public CalculatorForAreaPage navigateToCalculatorForAreaPage() {
		webDriver.navigate().to(BASE_URL + "1/convert_plosht.html");
		return new CalculatorForAreaPage(webDriver);
	}
	
}
