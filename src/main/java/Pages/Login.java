package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login  extends PageBase {


	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	private By EmailField = By.xpath("(//INPUT[@class='form-control'])[1]");
	private By PasswordField = By.xpath("(//INPUT[@class='form-control'])[2]");
	private By LoginBtn = By.xpath("(//BUTTON[@type='submit'])[1]"); 
	private By LoginHeaderText = By.xpath("(//SPAN)[15]"); 
	
	public void Login(String FirstName , String LastName ,String Phone , String Email ,String Password) {

		SendValues(EmailField,Email);
		SendValues(PasswordField,Password);
		Click2(LoginBtn);
	}
	
	public String VerifyLogin() {
		Wait2s();
		String STR=GetText(LoginHeaderText);
		System.out.println(STR);
		
		return STR;
	}
	
	
}
