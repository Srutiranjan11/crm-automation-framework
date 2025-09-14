package testngextra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCount {
	
	@Test(invocationCount = 10)
	public void createCity() {
		Reporter.log("create City....",true);
	}

}
