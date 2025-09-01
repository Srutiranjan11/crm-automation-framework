package extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		//Step--> 1 Get the java representation object of the physical File
		FileInputStream fis=new FileInputStream("D:\\Selenium Qspider\\vtiger-crm-framework-A11\\src\\test\\resources\\commonData.properties");
		
		//Step-->2 Load all the keys by Using Load() of properties Class
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step-->3 Get The Value By Passing Keys
		String BROWSER=pObj.getProperty("bro");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("un");
		String PASSWORD=pObj.getProperty("pwd");
		
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}

}
