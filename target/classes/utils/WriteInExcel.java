package main.resources.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriteInExcel {

    /*public static void createResultFile() throws FileNotFoundException {
        String file = "C:/Users/Tanaya.Bardhan/IdeaProjects/SeleniumTestNG/TestResult.xls";
        File f = new File(file);
        HSSFWorkbook workbook = new HSSFWorkbook();
        //Check if file already exists. If yes, delete and create. Else, only create.
        if (f.exists()) {
            f.delete();
            System.out.println("Deleted existing file..");

            FileOutputStream out = new FileOutputStream(new File("TestResult.xls"));
            System.out.println("Creating TestResult..");
        } else {
            FileOutputStream out = new FileOutputStream(new File("TestResult.xls"));
            System.out.println("Creating TestResult..");
        }
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        String[] columnNames = {"Sl. No.", "Method name", "Result"};
        int colIndex = 0;
        HSSFSheet sheet = workbook.createSheet("TestResult");

        //Filling out the column headers
        HSSFRow row = sheet.createRow((short) 0);
        for (int c = 0; c < 3; c++) {
            HSSFCell cell = row.createCell((short) c);
            //System.out.println("c is="+c);
            //System.out.println(columnNames[c]);
            cell.setCellValue(columnNames[c]);
        }
    }*/
}
