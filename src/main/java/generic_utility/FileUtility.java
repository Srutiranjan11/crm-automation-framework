package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Selenium Qspider\\vtiger-crm-framework-A11\\src\\test\\resources\\commonData.properties");

		Properties pObj = new Properties();

		pObj.load(fis);

		String value = pObj.getProperty(key);
		return value;
	}

	public String getStringDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream(
				"D:\\Selenium Qspider\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh=wb.getSheet(sheetName);
		
		String value1=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value1;
	}
	
	public int getNumericDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis3=new FileInputStream("D:\\Selenium Qspider\\vtiger-crm-framework-A11\\src\\test\\resources\\testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis3);
		Sheet sh=wb.getSheet(sheetName);
		
		int value=(int) sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
		return value;
	}

	// main Method
	public static void main(String[] args) throws IOException {
		FileUtility fUtil = new FileUtility();

		// method call for getDatafromproperties file
//		String result = fUtil.getDataFromPropertiesFile("url");
//		System.out.println(result);
		
		//method call for getStringDatafrom Excel file
//		String result=fUtil.getStringDataFromExcelFile("Sruti", 2, 0);
//		System.out.println(result);
		
		//method call for getNumericDatafrom Excel file
		int result=fUtil.getNumericDataFromExcelFile("Sruti", 2, 1);
		System.out.println(result);
	}

}
