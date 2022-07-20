package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class TestBase {

    public static String browser;
    public WebDriver driver;

    static String Url="https://www.phptravels.net/signup";
    	
    public void initWebDrivers() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        WebDriverManager.operadriver().setup();
       // WebDriverManager.iedriver().setup();
     //   WebDriverManager.edgedriver().setup();
    }

    public void maximizeBrowserWindow() {
        driver.manage().window().maximize();
       // driver.manage().window().fullscreen();
    }

    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browser) {
        initWebDrivers();
        TestBase.browser = browser;
    }
    
    public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30, 1));
    }
    
    public void SystemSignup() {
    	driver.get(Url);
    	//LoginPage logn =new LoginPage(driver);
    	//logn.LoginSteps();
    } 

    @BeforeClass
    public void beforeMethod() {
        launchWebBrowser();
        setImplicitWait();
        maximizeBrowserWindow();
        SystemSignup();
    }

    public void launchWebBrowser() {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();

            } else if (browser.equalsIgnoreCase("opera")) {

                OperaOptions options = new OperaOptions();
                options.setBinary("");
                driver = new OperaDriver(options);

            } else if (browser.equalsIgnoreCase("ie")) {
                driver = new InternetExplorerDriver();

            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else if (browser.equalsIgnoreCase("chrome-headless")) {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox-headless")) {
                FirefoxBinary firefoxBinary = new FirefoxBinary();
                firefoxBinary.addCommandLineOptions("--headless");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary(firefoxBinary);
                driver = new FirefoxDriver(firefoxOptions);
            } else {

            }
        } catch (WebDriverException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    @AfterSuite
    public void afterMethod() {
        //driver.quit();
    }

    public void check(WebElement chkCreateLoginDetails) {
        if (!chkCreateLoginDetails.isSelected()) {
            chkCreateLoginDetails.click();
        }
    }

    public void uncheck(WebElement chkCreateLoginDetails) {
        if (chkCreateLoginDetails.isSelected()) {
            chkCreateLoginDetails.click();
        }
    }


}