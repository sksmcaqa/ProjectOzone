package PageObject;

import org.openqa.selenium.By;

public class HomePage {
	
static By loginBtn = By.xpath("//a[contains(text(),'Sign up / Log in')]");
	
	public static By loginBtn () {		
		return loginBtn;
		
	}

}
