import java.sql.Driver;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Almosafer {
	WebDriver driver = new ChromeDriver();
	String URL = "https://global.almosafer.com/en";
	Random rand = new Random();

	@BeforeTest
	public void SetUp() {
		driver.get(URL);
		driver.manage().window().maximize();

		WebElement ButtonForTheCurrency = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		ButtonForTheCurrency.click();
	}

	@Test(priority = 1)
	public void TheLanguageisEnglish() {
		String ActualResult = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedResult = "en";
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 2)
	public void TheCurrency() {
		String ActualResult = driver.findElement(By.xpath("//Button[@data-testid='Header__CurrencySelector']"))
				.getText();
		String ExpectedResult = "SAR";
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 3)
	public void TheContactNumber() {
		String ActualResult = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedResult = "+966554400000";
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 4)
	public void TheFooter() {
		boolean ActualResult = driver.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ciodno.lkfeIG")).isDisplayed();
		boolean ExpectedResult = true;
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 5)
	public void HotelTap() {
		WebElement HotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ExpectedResult = "false";
		String ActualResult = HotelTap.getAttribute("aria-selected");
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

	@Test(priority = 6)
	public void CheckDepartureDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int Tomorrow = LocalDate.now().plusDays(1).getDayOfMonth();
		String ActualResult = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedResult = Integer.toString(Tomorrow);
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 7)
	public void CheckReturnDate() {

		int Today = LocalDate.now().getDayOfMonth();
		int AfterDayTomorrow = LocalDate.now().plusDays(2).getDayOfMonth();
		String ActualReturn = driver
				.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"))
				.getText();
		String ExpectedReturn = Integer.toString(AfterDayTomorrow);
		Assert.assertEquals(ActualReturn, ExpectedReturn);

	}

	@Test(priority = 8)
	public void Randomly() {
		String[] MyWebsites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
		int RandomIndex = rand.nextInt(MyWebsites.length);
		driver.get(MyWebsites[RandomIndex]);
		if (driver.getCurrentUrl().equals("https://www.almosafer.com/en")) {
			String ActualResult = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedResult = "en";
			Assert.assertEquals(ActualResult, ExpectedResult);


		} else {
			String ActualResult = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedResult = "ar";
			Assert.assertEquals(ActualResult, ExpectedResult);

		}

	}

}
