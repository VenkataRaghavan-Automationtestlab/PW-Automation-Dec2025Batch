package day25;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class SimpleReadExcel {
	
	public static void main(String[] args) throws IOException {
		
		// 1. Open file
		FileInputStream fis = new FileInputStream("./src/main/resources/excel/ReadExcel.xlsx");
		
		// 2. Load workbook
		Workbook workbook = new XSSFWorkbook(fis);

		// 3. Get sheet - pass sheet name
		Sheet sheet = workbook.getSheet("Sheet1");
		
		// 4. Get row (row index starts from 0)
		Row row = sheet.getRow(1); // 2nd row (Venkat)

		// 5. Get cells
		Cell nameCell = row.getCell(0);
		Cell cityCell = row.getCell(1);
		
		// 6. Print values
		System.out.println("Name: " + nameCell.toString());
		System.out.println("City: " + cityCell.toString());

		// 7. Close
		workbook.close();
		fis.close();
	}
}
