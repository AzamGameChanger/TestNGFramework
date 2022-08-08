package com.codewithazam.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

    private static Workbook book;
    private static Sheet sheet;

    private static void openExcel(String filePath) {
        FileInputStream fis;
        try {
            fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadSheet(String sheetName) {
        sheet = book.getSheet(sheetName);
    }

    private static int rowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    private static int colCount(int rowIndex) {
        return sheet.getRow(rowIndex).getLastCellNum();
    }

    private static String cellData(int rowIndex, int colIndex) {
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static Object[][] excelIntoArray(String filePath, String sheetName) {
        openExcel(filePath);
        loadSheet(sheetName);
        int rows = rowCount();
        int cols = colCount(0);

        Object[][] data = new Object[rows - 1][cols];

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                data[row - 1][col] = cellData(row, col);
            }
        }
        return data;
    }

}
