package MyPackOzone.ProjectOzone;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.*;
import Utility.UtilityFiles;

public class Base {
	WebDriver driver;
	Properties prop;
	SoftAssert assertion;
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));			
		assertion = new SoftAssert();
	}
		
	@Test(enabled=true, priority=1)
	public void homePgValidation() throws IOException {		
		driver.get(UtilityFiles.getPropertiesFileData("url"));
		assertion.assertTrue(driver.findElement(HomePage.loginBtn()).isDisplayed(),"Element is not displayed");
		driver.findElement(HomePage.loginBtn()).click();
		assertion.assertAll();
	}
	
	@Test(enabled=true, priority=2)
	public void loginPgValidation() throws InterruptedException {
		UtilityFiles.waitById(driver, LoginPage.signUpLink());
		assertion.assertTrue(driver.findElement(LoginPage.signUpLink()).isDisplayed(),"Element is not displayed");
	    UtilityFiles.clickElementByJavaScript(driver, LoginPage.signUpLink());
	    assertion.assertAll();
	}
	
	@Test(enabled=true, priority=3)
	public void signUpPgValidation() throws InterruptedException, IOException {
		UtilityFiles.waitById(driver, SignUpPage.signUpBtn());
		assertion.assertTrue(driver.findElement(SignUpPage.signUpBtn()).isDisplayed(),"Element is not displayed");
		UtilityFiles.clickElementByJavaScript(driver, SignUpPage.signUpBtn());
		
		driver.findElement(SignUpPage.accountName()).sendKeys(UtilityFiles.getPropertiesFileData("accountName"));
		driver.findElement(SignUpPage.email()).sendKeys(UtilityFiles.getPropertiesFileData("emailId"));
		driver.findElement(SignUpPage.password()).sendKeys(UtilityFiles.getPropertiesFileData("password"));
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);			
		UtilityFiles.clickElementByJavaScript(driver, SignUpPage.signUpBtnFinal());	
		assertion.assertAll();
	}
	
	@AfterClass
	public void endSession() {
		driver.quit();
	}

}
