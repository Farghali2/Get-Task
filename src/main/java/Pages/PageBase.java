package Pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

	protected WebDriver driver;
	
	//Click method
	public void Click(By ele) {
		WaitForClick(ele);
		driver.findElement(ele).click();		
	}
	
	public void Click2(By ele){
	WaitForClick(ele);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	WebElement Webele =driver.findElement(ele);
	executor.executeScript("arguments[0].click();", Webele);
	}
	

	//Double Click
	
	//select from list
	
	//send keys and values
	public void SendValues(By ele,String value) {
		driver.findElement(ele).clear();
		driver.findElement(ele).sendKeys(value);
	}
	//slide move down and up
	
	//Wait for click
	public void WaitForClick(By Sxpath ) {
		try {
			//new WebDriverWait(driver, Duration.ofSeconds(10, 1)).until(ExpectedConditions.presenceOfElementLocated(Sxpath));	
			//new WebDriverWait(driver, Duration.ofSeconds(10, 1)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Sxpath));
			new WebDriverWait(driver, Duration.ofSeconds(10, 1)).until(ExpectedConditions.elementToBeClickable(Sxpath));
		}
		catch (Exception e) {
		}
	}
	
	//wait 2s
	public void Wait2s() {
		By Sxpath = By.xpath("//A[text()=' mmCdfdsfancel']");
		try {
			new WebDriverWait(driver, Duration.ofSeconds(2, 1)).until(ExpectedConditions.visibilityOf(driver.findElement(Sxpath)));

		}
		catch (Exception e) {
		}
	}
	
	//wait till invisisable
		public void WaitTill(By Sxpath) {
			try {
				new WebDriverWait(driver, Duration.ofSeconds(5, 1)).until(ExpectedConditions.invisibilityOf(driver.findElement(Sxpath)));
			}
			catch (Exception e) {
			}
		}
	
	//Press Enter Key
	public void PressEnter(By x) {
		WebElement clk = this.driver.findElement(x);
		clk.sendKeys(Keys.ENTER);
	}
	
	//Get Text
	public String GetText(By x) {
		String Text = driver.findElement(x).getText();
		return Text;	

	}
	
	
}
