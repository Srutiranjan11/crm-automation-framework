package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888");

		// Login
		WebElement un = driver.findElement(By.name("user_name"));
		WebElement pwd = driver.findElement(By.name("user_password"));
		un.sendKeys("admin");
		pwd.sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		
		//Create Organization------>>
		
		//1.organization name
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		String orgName="Qspiders_"+(int)(Math.random()*9999);
		WebElement orgInputField=driver.findElement(By.name("accountname"));
		orgInputField.sendKeys(orgName);
		
		Thread.sleep(3000);
		
		//2.No.of Employees
		int ranNum=(int)(Math.random()*1000);
		String empNo=Integer.toString(ranNum);
		
		WebElement empField=driver.findElement(By.id("employees"));
		empField.sendKeys(empNo);
		
		Thread.sleep(2000);
		
		//3.industry
		WebElement indDD=driver.findElement(By.name("industry"));
		Select selInd=new Select(indDD);
		int options=selInd.getOptions().size();
		int ranIndex=(int) (Math.random() * options);
		selInd.selectByIndex(ranIndex);
		String industry=selInd.getFirstSelectedOption().getText();
		
		
		//Save button
		driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		
		Thread.sleep(5000);
		
		//verification----->>
		
		// 1. for organization name
		String actOrgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization Name Matched...");
//			System.out.println("Organization create Succesfully----->>>");
		}else {
			System.out.println("Organization Name not Matched !!!!");
//			System.out.println("Organization could not be created Succesfully !!!!");
		}
		
		
		//2.for Number of employees
		String actEmpno=driver.findElement(By.id("dtlview_Employees")).getText();
		if (actEmpno.equals(empNo)) {
			System.out.println("Employee number Matched !!!");
		}else {
			System.out.println("Employee number not Matched !!!");
		}
		
		//3. for Industry dropdown
		String actIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.equals(industry)) {
			System.out.println("Organization create Succesfully----->>>");
		}else {
			System.out.println("Organization could not be created Succesfully !!!!");
		}
		
		Thread.sleep(5000);
		
		// Logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		driver.findElement(By.linkText("Sign Out")).click();
//
		Thread.sleep(5000);
		driver.quit();
	}

}
