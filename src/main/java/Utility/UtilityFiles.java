package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilityFiles {
	
	public static void waitById(WebDriver driver, By id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(id));
	}
	
	public static void clickElementByJavaScript(WebDriver driver, By id) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(id));
	}
	
	public static String getPropertiesFileData(String propValue) throws IOException {
		Properties prop = new Properties();
		//please update the below properties file path as per your system path
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\ProjectOzone\\src\\main\\java\\Resources\\testData.properties");
		prop.load(fis);
		String value = prop.getProperty(propValue);
		return value;
	}
	
	
}




