package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends PageBase {
	
	
	public SignUp(WebDriver driver) {
		this.driver=driver;
	}
	
	private By FirstNameField = By.xpath("(//INPUT[@class='form-control'])[1]");
	private By LastNameField = By.xpath("(//INPUT[@class='form-control'])[2]");
	private By PhoneField = By.xpath("(//INPUT[@class='form-control'])[3]");
	private By EmailField = By.xpath("(//INPUT[@class='form-control'])[4]");
	private By PasswordField = By.xpath("(//INPUT[@class='form-control'])[5]"); 
	private By SubmitField = By.xpath("//BUTTON[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"); ////BUTTON[@type='submit']
	
	private By SignUpReg = By.xpath("//DIV[@class='alert alert-success signup']"); 
	
	
	public void NewRegistration(String FirstName , String LastName ,String Phone , String Email ,String Password) {
		
		SendValues(FirstNameField,FirstName);
		SendValues(LastNameField,LastName);
		SendValues(PhoneField,Phone);
		SendValues(EmailField,Email);
		SendValues(PasswordField,Password);
		Click2(SubmitField);
	}
	
	
	
}
