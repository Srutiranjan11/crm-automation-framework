package testngextra.annotation;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Execution extends DemoForConfiAnnotation{
	
	@Test
	public void createOrg() {
		Reporter.log("Create Organization",true);
	}
	
	@Test
	public void createEmail() {
		Reporter.log("Create Email",true);
	}

}
