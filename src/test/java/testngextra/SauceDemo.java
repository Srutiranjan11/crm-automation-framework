package testngextra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SauceDemo {

	@Test(dataProvider = "getData")
	public void sauceDemoLogin(String un, String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/v1/");

//		String un = "admin";
//		String pwd = "admin@123";

		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		Thread.sleep(5000);
		driver.quit();

	}

	@DataProvider
	public String[][] getData() {
		String[][] arr = new String[4][2];
//		no of rows = no of execution
//		no of cols = no of parameters

		arr[0][0] = "standard_user";
		arr[0][1] = "secret_sauce";

		arr[1][0] = "locked_out_user";
		arr[1][1] = "secret_sauce";

		arr[2][0] = "problem_user";
		arr[2][1] = "secret_sauce";

		arr[3][0] = "performance_glitch_user";
		arr[3][1] = "secret_sauce";

		return arr;
	}

}
