package task3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static void waitTillElementVisible(WebDriver driver, int timeSeconds, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeSeconds);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
		
	}
	
	public static void waitTillAnAlertIsPresent(WebDriver driver, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitTillElementClickable(WebDriver driver, int timeoutInSeconds, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void waitTillElementIsInvisible(WebDriver driver, int timeoutInSeconds, By by) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public static void waitElementVisibleWithFluentWait(WebDriver driver,int pollingTime, int timeoutInSeconds, By by) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
						.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
