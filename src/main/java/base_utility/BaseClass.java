package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import objectrepository.Homepage;
import objectrepository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;

	@BeforeSuite
	public void dbConnection() {
//		Reporter.log("Database connectivity + Report Cofiguration");
		System.out.println("Database connectivity + Report Cofiguration");
	}

	@BeforeTest
	public void precondition() {
//		Reporter.log("Preconditions..");
		System.out.println("Preconditions..");
	}

	@BeforeClass
	public void openBro() throws IOException {
		FileUtility futil = new FileUtility();

		String BROWSER = futil.getDataFromPropertiesFile("bro");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod
	public void login() throws IOException {
		FileUtility futil = new FileUtility();

		String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("un");
		String PASSWORD = futil.getDataFromPropertiesFile("pwd");
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUn();
		WebElement password = lp.getPwd();
		WebElement loginBtn = lp.getLoginBtn();

		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Homepage hp=new Homepage(driver);
		WebElement profile = hp.getProfile();
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);
		hp.getSignOut().click();

		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBro() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void postcondition() {
//		Reporter.log("Postconditon..");
		System.out.println("Postconditon..");
	}
	
	@AfterSuite
	public void dbClose() {
//		Reporter.log("Database Connectivity close + Report backup");
		System.out.println("Database Connectivity close + Report backup");
	}

}
