package testngextra;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {
	
	@Test(dataProvider = "getData")
	public void subjectFounder(String subject,String founder) {
//		Reporter.log("Selenium",true);
		Reporter.log(subject+" "+founder,true);
	}
	
	@DataProvider
	public String[][] getData() {
		String[][] arr=new String[5][2];
		
		arr[0][0]="Selenium";
		arr[0][1]="Jason Huggins";
		
		arr[1][0]="Java";
		arr[1][1]="James Gossling";
		
		arr[2][0]="SQL";
		arr[2][1]="Raymond Boyce";
		
		arr[3][0]="Js";
		arr[3][1]="Bredan Eich";
		
		arr[4][0]="HTML";
		arr[4][1]="Tim Berners-Lee";
		
		return arr;
	}

}
