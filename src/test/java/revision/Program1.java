package revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Program1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888");
		
		WebElement indDD=driver.findElement(By.name("industry"));
		
		Select selInd=new Select(indDD);
		
		int options=selInd.getOptions().size();
		
		int ranOpt=(int)(Math.random()* options);
		
		selInd.selectByIndex(ranOpt);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
