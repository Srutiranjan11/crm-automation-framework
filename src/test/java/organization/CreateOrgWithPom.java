package organization;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import objectrepository.Homepage;
import objectrepository.LoginPage;
import objectrepository.OrgPage;
import objectrepository.VerifyOrgPage;

public class CreateOrgWithPom {
	public static void main(String[] args) throws IOException, InterruptedException {

		FileUtility futil = new FileUtility();

		String URL = futil.getDataFromPropertiesFile("url");
		String USERNAME = futil.getDataFromPropertiesFile("un");
		String PASSWORD = futil.getDataFromPropertiesFile("pwd");

		String orgName = futil.getStringDataFromExcelFile("org", 3, 0) + (int) (Math.random() * 9999);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		// ============= Login ==================
		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUn();
		WebElement password = lp.getPwd();
		WebElement loginBtn = lp.getLoginBtn();

		driver.navigate().refresh();

		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.click();

		// ============CreateOrganization ==========

		Homepage hp = new Homepage(driver);
		WebElement orgLink = hp.getOrgLink();
		orgLink.click();
		OrgPage op = new OrgPage(driver);
		op.getPlusIcon().click();

		WebElement orgNameField = op.getOrgNameField();
		orgNameField.sendKeys(orgName);

		// submit button
		op.getSubmitBtn().click();
		Thread.sleep(4000);

		// ====================Verification ===============
		/**
		 * Organization name verification
		 */
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getActOrgField().getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Oragnization create succesfulyy -->>");
		} else {
			System.out.println("Oragnization not create succesfulyy !!!");
		}

		// ============================Log out ==================
		WebElement profile = hp.getProfile();
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.hover(profile);
		hp.getSignOut().click();

		Thread.sleep(3000);
		driver.quit();

	}

}
