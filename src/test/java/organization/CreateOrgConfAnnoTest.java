package organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import objectrepository.Homepage;
import objectrepository.OrgPage;
import objectrepository.VerifyOrgPage;

public class CreateOrgConfAnnoTest extends BaseClass {
	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility futil=new FileUtility();
		
		String orgName = futil.getStringDataFromExcelFile("org", 3, 0) + (int) (Math.random() * 9999);
		
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
		
		//==========verification ============
		
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getActOrgField().getText();
		Assert.assertEquals(actOrgName, orgName);
	}

}
