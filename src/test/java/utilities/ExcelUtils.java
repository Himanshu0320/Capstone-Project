package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) {

        Object[][] data = null;

        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue;

                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);

                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
                }
            }

            workbook.close();
            file.close();

        } catch (Exception e) {
            System.out.println("❌ Excel reading failed: " + e.getMessage());
            e.printStackTrace();

            // VERY IMPORTANT FIX
            return new Object[0][0];
        }

        return data;
    }
}