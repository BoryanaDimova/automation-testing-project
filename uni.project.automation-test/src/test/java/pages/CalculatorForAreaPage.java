package pages;

import static org.junit.Assert.fail;

import java.util.HashMap; 
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorForAreaPage extends KonventorPage{

	@FindBy(id="suma")
	private WebElement valueToConvert;
	
	@FindBy(id="ot")
	private WebElement fromUnit;
	
	
	@FindBy(id="kam")
	private WebElement toUnit;
	
	@FindBy(className="presmetni_b")
	private WebElement convertButton;
	
	@FindBy(className="izchisti_b")
	private WebElement clearButton;
	
	
	public CalculatorForAreaPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	
	public CalculatorForAreaPage setValueToConvert(Double value) throws InterruptedException {
		valueToConvert.sendKeys(value.toString());
		return this;
	}
	
	public String getConvertValue() throws InterruptedException{
		return getFieldValue(valueToConvert);
	}
	
	public CalculatorForAreaPage setFromUnit(Units unit) throws InterruptedException {
		fromUnit.sendKeys(unitsMap.get(unit));
		return this;
	}
	
	public String getFromUnitValue() {
		return getFieldValue(fromUnit);
	}

	public CalculatorForAreaPage setToUnit(Units unit) throws InterruptedException {
		toUnit.sendKeys(unitsMap.get(unit));
		return this;
	}
	
	public String getToUnitValue() {
		return getFieldValue(toUnit);
	}

	public CalculatorForAreaPage convert() {
		convertButton.click();
		return this;
	}
	
	public CalculatorForAreaPage clear() {
		clearButton.click();
		return new CalculatorForAreaPage(webDriver);
	}

	public CalculatorForAreaPage submitForm(Double value, Units fromUnit, Units toUnit) throws InterruptedException {
			setValueToConvert(value);
			setFromUnit(fromUnit);
			setToUnit(toUnit);
			return convert();		
	}
	
	public CalculatorForAreaPage clearForm() {
		return clear();		
	}

	
	public String getConvertedResult() throws InterruptedException{
		return webDriver.findElement(By.xpath("//*[@id=\"result\"]/p[2]")).getText();
	}
	
	public static Map<Units, String> unitsMap = new HashMap<Units, String>(){
			private static final long serialVersionUID = 1L;
	{
	    put(Units.SquareKilometer, "Кв.километър (km²)");
	    put(Units.Hectare, "Хектар");
	    put(Units.Decare, "Декар");
	    put(Units.Ar, "Ар");
	    put(Units.SquareMeter, "Кв.метър (m²)");
	    put(Units.SquareDecimeter, "Кв.дециметър (dm²)");
	    put(Units.SquareCentimeter, "Кв.сантиметър (cm²)");
	    put(Units.SquareMilimeter, "Кв.милиметър (mm²)");
	    put(Units.SquareMile, "Кв.миля (Square mile)");
	    put(Units.Acre, "Акър (Acre)");
	    put(Units.Rood, "Рууд (Rood)");
	    put(Units.SquareRod, "Кв.род (Square rod)");
	    put(Units.Square, "Квадрат (Square)");
	    put(Units.SquareYard, "Кв.ярд (Square yard (yr²))");
	    put(Units.SquareFoot, "Кв.фут (Square foot (ft²))");
	    put(Units.SquareInch, "Кв.инч( Square inch (in²))");
	}};
	
	public static Map<Integer, String> unitsValuesMap = new HashMap<Integer, String>(){
		private static final long serialVersionUID = 1L;
{
    put(0, "Кв.километър (km²)");
    put(1, "Хектар");
    put(2, "Декар");
    put(3, "Ар");
    put(4, "Кв.метър (m²)");
    put(5, "Кв.дециметър (dm²)");
    put(6, "Кв.сантиметър (cm²)");
    put(7, "Кв.милиметър (mm²)");
    put(8, "Кв.миля (Square mile)");
    put(9, "Акър (Acre)");
    put(10, "Рууд (Rood)");
    put(11, "Кв.род (Square rod)");
    put(12, "Квадрат (Square)");
    put(13, "Кв.ярд (Square yard (yr²))");
    put(14, "Кв.фут (Square foot (ft²))");
    put(15, "Кв.инч( Square inch (in²))");
}};
	
}
