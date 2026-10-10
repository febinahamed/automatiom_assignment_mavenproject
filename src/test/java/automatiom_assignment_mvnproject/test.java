package automatiom_assignment_mvnproject;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {
		
		@Test
		public void Flipcart() throws InterruptedException
		{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/search");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("apple 18");
		
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		Thread.sleep(5000);
		
		List<WebElement> searchResultsElments=driver.findElements(By.xpath("//div[contains(@data-tkid,'SEARCH')]"));
		
		
		for (WebElement searchElement : searchResultsElments) {
			
			String searchResultString=  searchElement.getText();
			System.out.println(searchResultString);
			
		    Assert.assertTrue(searchResultString.contains("Apple"));
			//assertTrue(searchResultString.equalsIgnoreCase("apple"));

			
		}
	}


}
