package Tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.SignUp;
import utilities.ScreenRecorder;


public class TCs extends TestBase {
	SignUp object;
	Login Ob2;

	@DataProvider(name = "test-data")
	public static Object[][] data(){
		return new Object[][]
				{
			{"Mohamed","Farghali","1232131233","mmwedfasdarghali240@gmail.com","123123"}
				};	
	}
	
	
	//Successful Registration 
  	@Test(priority = 0 , dataProvider = "test-data")
	public void test1(String FirstName , String LastName ,String Phone , String Email ,String Password) throws Exception {
  		ScreenRecorder.startRecording("GetTask");
  		object=new SignUp(driver);
  		object.NewRegistration(FirstName,LastName,Phone,Email,Password);
        ScreenRecorder.stopRecording();
	}
  	
    //Successful Login 
  	@Test(priority = 1 , dataProvider = "test-data")
	public void test2(String FirstName , String LastName ,String Phone , String Email ,String Password) {
  		Ob2=new Login(driver);
  		Ob2.Login(FirstName, LastName, Phone, Email, Password);
  		String res=Ob2.VerifyLogin();
  		Assert.assertEquals(res, FirstName);  		
	}
	
}
