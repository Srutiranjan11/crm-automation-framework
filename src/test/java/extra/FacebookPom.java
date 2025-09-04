package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import extraobjectrepository.LoginpageFaceBook;

public class FacebookPom {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");
		
//		WebElement username=driver.findElement(By.id("email"));
//		WebElement password=driver.findElement(By.id("pass"));
//		WebElement loginBtn=driver.findElement(By.name("login"));
		
		LoginpageFaceBook lp=new LoginpageFaceBook(driver);
		WebElement username=lp.getUn();
		WebElement password=lp.getPwd();
		WebElement loginBtn=lp.getLoginBtn();
		
		driver.navigate().refresh();
		
		username.sendKeys("9245686833");
		password.sendKeys("123we");
		loginBtn.click();
		
		Thread.sleep(10000);
		driver.quit();
	}

}
