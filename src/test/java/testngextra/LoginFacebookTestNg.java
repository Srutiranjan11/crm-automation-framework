package testngextra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import extraobjectrepository.LoginpageFaceBook;

public class LoginFacebookTestNg {
	
	@Test
	public void loginFaceBook() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");
		
		LoginpageFaceBook lp=new LoginpageFaceBook(driver);
		WebElement username=lp.getUn();
		WebElement password=lp.getPwd();
		WebElement loginBtn=lp.getLoginBtn();
		
		username.sendKeys("dippp@1233");
		password.sendKeys("qwer344");
		loginBtn.click();
		
		Thread.sleep(7000);
		
		driver.quit();
		
	}

}
