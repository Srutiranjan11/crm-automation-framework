package extra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		
		//get the java Representation Object of the physical file
		
		FileInputStream fis=new FileInputStream("C:\\Users\\sruti\\OneDrive\\Desktop\\Selenium\\TestScriptData.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("SrutiData");
		Row row=sh.getRow(7);
		Cell cell=row.getCell(2);
//		String data=cell.getStringCellValue();
//		Boolean data1=cell.getBooleanCellValue();
//		int data3=(int) cell.getNumericCellValue();
		double data4=cell.getNumericCellValue();
		
//		System.out.println(data+(int)(Math.random()*999));
		System.out.println(data4);
		

	}

}
