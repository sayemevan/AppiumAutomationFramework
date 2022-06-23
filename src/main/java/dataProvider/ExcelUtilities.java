package dataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static register.DataProvider.*;

public class ExcelUtilities {

    public static boolean excelSheetDataGet(String fileName, String fileLocation, String dataSheetName, String extraParam) {
        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
        String excelFile;
        XSSFWorkbook workbook;
        XSSFSheet sheet;
        try {
            if(fileName == null || fileLocation == null){
                return false;
            }
            excelFile = fileLocation + fileName;
            if (!excelFile.contains(".xlsx")) {
                excelFile = excelFile + ".xlsx";
            }

            workbook = new XSSFWorkbook(excelFile);

            dataSheetName = dataSheetName.trim();
            if (workbook.getSheet(dataSheetName) != null) {
                sheet = workbook.getSheet(dataSheetName);
            } else {
                System.out.println("DataSheet is not found, please check sheet name!");
                workbook.close();
                return false;
            }

            int rowCount = sheet.getLastRowNum();
            if (sheet.getRow(0).getLastCellNum() > 0) {
                String value, key;
                for (int i = 1; i <= rowCount; i++) {
                    Row row = sheet.getRow(0);
                    LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        if (emptyCellCheck(sheet, i, j)) {
                            key = row.getCell(j).getStringCellValue().trim();
                            value = sheet.getRow(i).getCell(j).getStringCellValue();
                            rowData.put(key, value);
                        }
                    }
                    dataList.add(rowData);
                }
                excelSheetList.put(dataSheetName, dataList);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Excel sheet null value handler
    public static boolean emptyCellCheck(XSSFSheet xssfSheet, int row, int col) {
        try {
            return xssfSheet.getRow(row).getCell(col) != null
                    && xssfSheet.getRow(row).getCell(col).getStringCellValue() != null
                    && !xssfSheet.getRow(row).getCell(col).getStringCellValue().isEmpty();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void excelSheetDataWrite(String fileLocation, String fileName, String dataSheetName, String acutalText, String testStatus,int rowid) {
        try {
            File file = new File(fileLocation + fileName);
            FileInputStream inputStream = new FileInputStream(file);
            Workbook writeExcelBook = null;
            writeExcelBook = new XSSFWorkbook(inputStream);
            Sheet sheet = writeExcelBook.getSheet(dataSheetName);
            Row fillRow = sheet.getRow(rowid);

            Cell cell = fillRow.createCell(fillRow.getLastCellNum() - 2);
            Cell cell2 = fillRow.createCell(fillRow.getLastCellNum() - 1);
            cell.setCellValue(acutalText);
            cell2.setCellValue(testStatus);

            inputStream.close();
            FileOutputStream outputStream = new FileOutputStream(file);
            writeExcelBook.write(outputStream);
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
