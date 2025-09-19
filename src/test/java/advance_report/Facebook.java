package advance_report;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Facebook {
	ExtentReports report=new ExtentReports();
	
	@BeforeSuite
	public void configRep() {
		
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String time=now.format(dtf);

		ExtentSparkReporter spark=new ExtentSparkReporter("./advance_html_report/"+time+".html");
		spark.config().setDocumentTitle("Facebook report");
		spark.config().setReportName("First report");
		spark.config().setTheme(Theme.DARK);
		
		
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chromium");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Version", "11");
	}
	
	
	@Test
	public void advanRepo() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");
		
		
		ExtentTest test=report.createTest("Login");
		test.log(Status.INFO, "This is Info.......");
		test.log(Status.PASS, "This is passed.......");
		test.log(Status.WARNING, "This is Warning.........");
		test.log(Status.SKIP, "This is Skipped.........");
		test.log(Status.FAIL, "This is failed.....");
		
		TakesScreenshot tks=(TakesScreenshot) driver;
		String ss=tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss,"image of ss");
		
		driver.quit();
	}
	
	@AfterSuite
	public void repBackup() {
		report.flush();
	}

}
