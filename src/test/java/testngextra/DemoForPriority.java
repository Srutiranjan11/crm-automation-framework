package testngextra;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoForPriority {
	
	@Test(priority = -1)
	public void login() {
//		System.out.println("Login successfully ....");
		Reporter.log("Login successfully ....");
	}
	
	@Test(priority = 2)
	public void searchProduct() {
//		System.out.println("Searched...");
		Reporter.log("Searched...");
	}
	
	@Test(priority = 0)
	public void addToCart() {
//		System.out.println("Added to cart...");
		Reporter.log("Added to cart...");
		Assert.assertTrue(false);
	}
	
	@Test(priority = 1)
	public void payment() {
//		System.out.println("Payment Done");
		Reporter.log("Payment Done");
	}

}
