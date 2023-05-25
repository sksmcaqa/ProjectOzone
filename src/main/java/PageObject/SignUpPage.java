package PageObject;

import org.openqa.selenium.By;

public class SignUpPage {
		
	static By signUpBtn = By.id("SignUp_EmailField");
	static By accountName = By.id("SignUp_AccountNameField");
	static By email = By.id("SignUp_EmailField");
	static By password= By.id("SignUp_PasswordField");
	static By signUpBtnFinal = By.id("SignUp_SubmitForVerification");
	
	public static By signUpBtn() {
		return signUpBtn;
	}
	
	public static By accountName() {
		return accountName;
	}
	
	public static By email() {
		return email;
	}
	
	public static By password() {
		return password;
	}	
	
	public static By signUpBtnFinal() {
		return signUpBtnFinal;
	}

}
