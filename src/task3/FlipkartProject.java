package task3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FlipkartProject {
	
	ChromeDriver driver;
	String url = "https://flipkart.com";
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Administrator\\Desktop\\Selenium Testing\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(url);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
	
	@Test
	public void mouseHover() {
		Actions action = new Actions(driver);
		
		WebElement electronicsLink = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
		
		action.moveToElement(electronicsLink).build().perform();
		
		WaitUtils.waitTillElementVisible(driver, 10, By.linkText("Samsung"));
		
		WaitUtils.waitElementVisibleWithFluentWait(driver, 500, 10, By.linkText("Samsung"));
		
		WebElement samsungLink = driver.findElement(By.linkText("Samsung"));
		action.moveToElement(samsungLink).click(samsungLink).build().perform();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
