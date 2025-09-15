package typesOfExecution;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo4Test {
	
	@Test(groups = "smoke")
	public void case4() {
		Reporter.log("This is Smoke testing",true);
	}
	
	@Test(groups = "regression")
	public void case5() {
		Reporter.log("This is Regression testing",true);
	}
	
	@Test(groups = "smoke")
	public void case6() {
		Reporter.log("This is Smoke testing",true);
	}

}
