package day2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		
		// 1. Open file
				FileInputStream fis = new FileInputStream("./src/test/resources/ReadData.xlsx");
				
				// 2. Load workbook
				Workbook workbook = new XSSFWorkbook(fis);

				// 3. Get sheet - pass sheet name
				Sheet sheet = workbook.getSheet("Data");
				
				// 4. Get row (row index starts from 0)
				int lastRow = sheet.getLastRowNum(); // last row index

		        for (int i = 1; i <= lastRow; i++) {   // start from 1 to skip header

		            Row row = sheet.getRow(i);

		            String Name = row.getCell(0).toString();
		            String City = row.getCell(1).toString();

		            System.out.println(Name + " | " + City);
		        }

				// 7. Close
				workbook.close();
				fis.close();
		
	}

}
