package revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CrmswCreateorg_1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888");
		
		//login
		WebElement username=driver.findElement(By.name("user_name"));
		WebElement pwd=driver.findElement(By.name("user_password"));
		username.sendKeys("admin");
		pwd.sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//organization Name
		String orgname="Qspider_"+(int)(Math.random()*1000);
		WebElement orginputfield=driver.findElement(By.name("accountname"));
		orginputfield.sendKeys(orgname);
		
		//employees Number
		int ranNum=(int)(Math.random()*1000);
		String empNo=Integer.toString(ranNum);
		WebElement empInputfield=driver.findElement(By.id("employees"));
		empInputfield.sendKeys(empNo);
		
		//Industry
		WebElement industrySelDD=driver.findElement(By.name("industry"));
		Select selindDD=new Select(industrySelDD);
		int options=selindDD.getOptions().size();
		int ranIndex=(int)(Math.random()*options);
		selindDD.selectByIndex(ranIndex);
		String industry=selindDD.getFirstSelectedOption().getText();
		
		//save
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		//Verification
		
		//Organization name verification
		
		String actualOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actualOrgName.equals(orgname)) {
			System.out.println("Organization name mathed succesfully...");
		} else {
			System.out.println("Organization name not mathed !!!");
		}
		
		//employee number verification
		String actualEmpNum=driver.findElement(By.id("dtlview_Employees")).getText();
		if (actualEmpNum.equals(empNo)) {
			System.out.println("Employee number mathed succesfully...");
		} else {
			System.out.println("Employee number not mathed !!!");
		}
		
		//Industry name verification
		String actualIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if (actualIndustry.equals(industry)) {
			System.out.println("Industry Name mathed succesfully...");
		} else {
			System.out.println("Industry Name Not mathed !!!");
		}
		
		
		
		//logout
		WebElement profileicon=driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(profileicon).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}

}
