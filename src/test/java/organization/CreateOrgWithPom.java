package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import objectrepository.Homepage;
import objectrepository.LoginPage;

public class CreateOrgWithPom {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream("D:\\Selenium Qspider\\vtiger-crm-framework-A11\\src\\test\\resources\\commonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String BROWSER=pObj.getProperty("bro");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("un");
		String PASSWORD=pObj.getProperty("pwd");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		//============= Login ==================
//		WebElement un=driver.findElement(By.name("user_name"));
//		WebElement pwd=driver.findElement(By.name("user_password"));
//		WebElement loginBtn=driver.findElement(By.id("submitButton"));
		
		LoginPage lp=new LoginPage(driver);
		WebElement username=lp.getUn();
		WebElement password=lp.getPwd();
		WebElement loginBtn =lp.getLoginBtn();
		
		driver.navigate().refresh();
		
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.click();
		
		//============CreateOrganization ==========
		
		
//		driver.findElement(By.linkText("Organizations")).click();
		
		Homepage hp=new Homepage(driver);
		WebElement orgLink=hp.getOrgLink();
		orgLink.click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
