package testngextra;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethod {
	
	@Test
	public void createCity() {
		Reporter.log("City Created To ==> Noida");
		Assert.assertTrue(true);
	}
	
	@Test(dependsOnMethods = "createCity")
	public void modifyCity() {
		Reporter.log("City Created To ==> Noida");
		Reporter.log("City Modify to ==> Greater Noida");
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = "modifyCity")
	public void deleteCity() {
		Reporter.log("City Created To ==> Noida");
		Reporter.log("City Modify to ==> Greater Noida");
		Reporter.log("City Deleted ...");
	}

}
