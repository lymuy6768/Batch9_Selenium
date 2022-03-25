package excelTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class firstWriteExcelTest {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath="/Users/lymheng/eclipse-workspace/Batch9_Selenium/src/test/resources/dataFolder/data.xlsx";
		
		FileInputStream fs= new FileInputStream(excelPath);//open connection to the file
		
		 XSSFWorkbook wb = new XSSFWorkbook(fs);//connection to workbook
		 
		 XSSFSheet sheet= wb.getSheet("Sheet1");//connection to sheet
		 
		 int lastRow= sheet.getLastRowNum();
		 System.out.println(lastRow);
		
		
		for(int i=1;i<=lastRow;i++) {
			Row row = sheet.getRow(i);
			Cell cell= row.createCell(5);
			
			cell.setCellValue("pass");
		}
		 FileOutputStream fos= new FileOutputStream(excelPath);
		 wb.write(fos);
		 fos.close();
		 
		
		
		
	}

}
