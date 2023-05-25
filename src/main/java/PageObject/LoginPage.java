package PageObject;

import org.openqa.selenium.By;

public class LoginPage {
	
	static By signUpLink = By.xpath("//a[contains(text(),'Sign up')]");	
	
	public static By signUpLink() {
		return signUpLink;
	}

}
