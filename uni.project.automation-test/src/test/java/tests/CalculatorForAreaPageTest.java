package tests;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.seljup.SeleniumExtension;
import pages.BasePage;
import pages.CalculatorForAreaPage;
import pages.HomePage;
import pages.Units;

@ExtendWith(SeleniumExtension.class)
public class CalculatorForAreaPageTest {

	@Test
	public void CalculatorForAreaPageOpenTest(ChromeDriver driver) throws InterruptedException {
		new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();
		
		assertEquals(BasePage.BASE_URL + "1/convert_plosht.html", driver.getCurrentUrl());
	}
	
	@Test
	public void testConvert1SquareMeterToSquareFoot_1m(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(1.00, Units.SquareMeter, Units.SquareFoot);
		sleep(100);
		 
		assertEquals("1 Кв.метър (m²) = 10.76 Кв.фута", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
	
	
	@Test
	public void testConvertSquareMeterToSquareFoot_1dot01m(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(1.01, Units.SquareMeter, Units.SquareFoot);
		sleep(100);
		 
		assertEquals("1.01 m² = 10.87 Кв.фута", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
	
	@Test
	public void testConvertSquareMeterToSquareFoot_200m(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(200.0, Units.SquareMeter, Units.SquareFoot);
		sleep(100);
		 
		assertEquals("200 m² = 2152.78 Кв.фута", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
	
	@Test
	public void testConvertSquareMeterToSquareFoot_ClearForm(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(200.0, Units.SquareMeter, Units.SquareFoot);
		sleep(100);
		 
		assertEquals("200 m² = 2152.78 Кв.фута", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
		
		automatedCalculatorForAreaPage.clear();
		
		assertTrue(automatedCalculatorForAreaPage.getConvertValue().isBlank());
		String fromValueName = CalculatorForAreaPage.unitsValuesMap.get(Integer.valueOf(automatedCalculatorForAreaPage.getFromUnitValue()));
		assertEquals(CalculatorForAreaPage.unitsMap.get(Units.SquareMeter),fromValueName);
		
		String toValueName = CalculatorForAreaPage.unitsValuesMap.get(Integer.valueOf(automatedCalculatorForAreaPage.getToUnitValue()));
		assertEquals(CalculatorForAreaPage.unitsMap.get(Units.SquareMeter),toValueName);
		
		try {
			automatedCalculatorForAreaPage.getConvertedResult();
			assert false;
		}catch(Exception e) {
			assert true;
			assertTrue(e.getMessage().contains("no such element"));
		}	
	}
	
	@Test
	public void testConvert1SquareFootToSquareMeter_1foot(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(1.00, Units.SquareFoot, Units.SquareMeter);
		sleep(100);
		 
		assertEquals("1 Кв.фут (Square foot (ft²)) = 0.09 Кв.метър (m²)", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
	
	
	@Test
	public void testConvertSquareFootToSquareMeter_10foot(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(10.0, Units.SquareFoot, Units.SquareMeter);
		sleep(100);
		 
		assertEquals("10 Кв.фута = 0.93 Кв.метър (m²)", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
	
	@Test
	public void testConvertSquareFootToSquareMeter_10dot9foot(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(10.9, Units.SquareFoot, Units.SquareMeter);
		sleep(100);
		 
		assertEquals("10.9 Кв.фута = 1.01 m²", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
			
	@Test
	public void testConvertSquareFootToSquareMeter_200foots(ChromeDriver driver) throws InterruptedException {
		
		CalculatorForAreaPage automatedCalculatorForAreaPage = new HomePage(driver)
		.navigateToKonventorPage()
		.navigateToCalculatorForAreaPage();

		automatedCalculatorForAreaPage.submitForm(200.0, Units.SquareFoot,  Units.SquareMeter);
		sleep(100);
		 
		assertEquals("200 Кв.фута = 18.58 m²", automatedCalculatorForAreaPage.getConvertedResult());
		sleep(100);
	}
}
