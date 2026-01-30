package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleReadExcel {

	public static void main(String[] args) throws IOException {
		
		
		// 1. Create workbook
        Workbook workbook = new XSSFWorkbook();

        // 2. Create sheet
        Sheet sheet = workbook.createSheet("Data");

        // 3. Create row
        Row row = sheet.createRow(0);

        // 4. Create cells and set values
        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("City");
        
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Hari");
        row1.createCell(1).setCellValue("Pune");
        
        // 5. Write to file
        FileOutputStream fos = new FileOutputStream("./src/test/resources/WriteData.xlsx");
        workbook.write(fos);

        // 6. Close
        workbook.close();
        fos.close();

        System.out.println("✅ Simple.xlsx created successfully!");
		
	}
}
