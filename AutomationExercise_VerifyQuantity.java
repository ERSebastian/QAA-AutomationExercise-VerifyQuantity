package jar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AutomationExercise_VerifyQuantity {
	
	WebDriver driver;
	String url="https://automationexercise.com/";
	String driverPath="..\\AutomationPractice\\\\Drivers\\\\chromedriver.exe";
	Actions actions;
	
	@BeforeSuite
		public void SetUp() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			ChromeOptions options=new ChromeOptions();
	        options.addArguments("remote-allow-origins=*");
	        driver=new ChromeDriver(options);
	        driver.get(url);
	        actions = new Actions(driver);
	}
	
	@AfterSuite
	public void CloseNav() {
		//driver.close();
	}
	
	
	@Test
	public void CartQuantity() {
		
		WebElement checkPage=driver.findElement(By.xpath("//h2[contains(text(),'Features Items')]"));
		String actualLabel = checkPage.getText();
		String expectedLabel = ("FEATURES ITEMS");
		Assert.assertEquals(actualLabel, expectedLabel);
		
		WebElement viewProduct=driver.findElement(By.xpath("//body/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]"));
		actions.moveToElement(viewProduct).click().perform();
		
		WebElement closePopup=driver.findElement(By.id("dismiss-button"));
		actions.moveToElement(closePopup).click().perform();
		
		WebElement checkItem=driver.findElement(By.cssSelector("h2"));
		String actualLabel2 = checkItem.getText();
		String expectedLabel2 = ("Blue Top");
		Assert.assertEquals(actualLabel2, expectedLabel2);
		
		WebElement quantity=driver.findElement(By.name("quantity"));
		quantity.sendKeys("4");
		
		WebElement addToCart=driver.findElement(By.cssSelector("btn-default cart"));
		actions.moveToElement(addToCart).click().perform();
		
		WebElement checkAdded=driver.findElement(By.cssSelector("modal-title"));
		String actualLabel3 = checkAdded.getText();
		String expectedLabel3 = ("Added!");
		Assert.assertEquals(actualLabel3, expectedLabel3);
		
		WebElement viewCart=driver.findElement(By.cssSelector("a[href='/view_cart']"));
		actions.moveToElement(viewCart).click().perform();
		
		WebElement checkQuantity=driver.findElement(By.cssSelector("button.disabled"));
		String actualLabel4 = checkQuantity.getText();
		String expectedLabel4 = ("4");
		Assert.assertEquals(actualLabel4, expectedLabel4);
	
		
	}
	
	
		
	

}
