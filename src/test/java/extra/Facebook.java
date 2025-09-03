package extra;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility;

public class Facebook {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.maximizeWindow();
		wdUtil.implicitWait();
		
//		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.get("https://shoppersstack.com/products_page/39");
		Thread.sleep(20000);
		String pId=driver.getWindowHandle();
		driver.findElement(By.id("compare")).click();
		wdUtil.closeAllChildWindow(pId);
		
		driver.close();
		
		wdUtil.switchToParentWindow(pId);
		
//		WebElement dayDD=driver.findElement(By.id("day"));
//		WebElement monthDD=driver.findElement(By.id("month"));
//		WebElement yearDD=driver.findElement(By.id("year"));
//		
//		wdUtil.select(dayDD, 1);
//		wdUtil.select(monthDD, "11");
//		wdUtil.select("2000", yearDD);
		
//		wdUtil.takeScreenShot("facebookcreateAcc");
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
