package excelTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FirstExcelTest {
	public static void main(String[] args) throws IOException {
		
		String excelPath="/Users/lymheng/eclipse-workspace/Batch9_Selenium/src/test/resources/dataFolder/data.xlsx";
		
		FileInputStream fs= new FileInputStream(excelPath);//open connection to the file
		
		XSSFWorkbook workbook= new XSSFWorkbook(fs);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		
		Row row= sheet.getRow(0);//sheet is collection of rows
		Cell cell= row.getCell(0);//row is collection of cells
	//	System.out.println("1- "+ sheet.getRow(0).getCell(0));
		
		System.out.println("Iterating over Rows and columns using for each loop");
		DataFormatter objDefaultFormat = new DataFormatter();//
		
		for(Row row1 : sheet) {
			for(Cell cell1 : row1) {
				String cellValue = objDefaultFormat.formatCellValue(cell1);
				System.out.println(cellValue + " \t");
			}
			System.out.println("  ");
		}
		
		
		
	}

}
