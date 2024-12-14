import java.sql.Driver;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Almosafer {
	WebDriver driver = new ChromeDriver ();
	String URL = "https://global.almosafer.com/en"; 
	
	
	@BeforeTest
	public void SetUp() {
		driver.get(URL);
		driver.manage().window().maximize();
		
	WebElement ButtonForTheCurrency = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
	ButtonForTheCurrency.click();
	}
	
	
	@Test(priority=1)
	public void TheLanguageisEnglish() {
		String ActualResult = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedResult = "en";
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}
	@Test(priority=2)
	public void TheCurrency () {
		String ActualResult = driver.findElement(By.xpath("//Button[@data-testid='Header__CurrencySelector']")).getText();
		String ExpectedResult = "SAR";
		Assert.assertEquals(ActualResult, ExpectedResult); 
		
	}
	@Test(priority=3)
	public void TheContactNumber () {
		String ActualResult = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedResult = "+966554400000";
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		
	}
	@Test(priority=4)
	public void TheFooter () {
		boolean ActualResult =driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean ExpectedResult = true;
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

}
