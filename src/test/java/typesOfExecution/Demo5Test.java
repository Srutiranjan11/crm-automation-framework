package typesOfExecution;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo5Test {
	
	@Test(groups = "regression")
	public void case7() {
		Reporter.log("This is Regression testing",true);
	}
	
	@Test(groups = "regression")
	public void case8() {
		Reporter.log("This is Regression testing",true);
	}
	
	@Test(groups = "smoke")
	public void case9() {
		Reporter.log("This is Smoke testing",true);
	}

}
