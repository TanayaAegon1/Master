package main.resources.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.CellType;



public class ReadDataFromExcel {
    String s1;

    public String readExcel(int TestCaseID, String ColumnName, String TabName) throws IOException {
        String filePath = "C:/Users/Tanaya.Bardhan/IdeaProjects/SeleniumTestNG/TestDataSheet.xls";
        //Create an object of File class to open xlsx file
        File file = new File(filePath);
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        Workbook TestDataSheet = null;
        //Find the file extension by splitting file name in substring  and getting only extension name
        String fileExtensionName = filePath.substring(filePath.lastIndexOf("."));
        //Check condition if the file is xlsx file
        if (fileExtensionName.equals(".xlsx")) {
            //If it is xls file then create object of XSSFWorkbook class
            System.out.println("Invalid format. Change file format to .xls");
        }
        //Check condition if the file is xls file
        else if (fileExtensionName.equals(".xls")) {
            //If it is xls file then create object of HSSFWorkbook class
            TestDataSheet = new HSSFWorkbook(inputStream);
            //System.out.println("Reading excel file....");
        }

        //Read sheet inside the workbook by its name
        Sheet sheet = TestDataSheet.getSheet(TabName);
        int colIndex = 0;
        String s;

        for (int rowCount = 0; rowCount < sheet.getLastRowNum(); rowCount++) {
            Row row = sheet.getRow(rowCount);
            for (int columnNumber = 0; columnNumber < row.getLastCellNum(); columnNumber++) {
                Cell cell = row.getCell(columnNumber);
                cell.setCellType(CellType.STRING);
                String data0 = cell.getStringCellValue();
                //System.out.println("Data is:"+data0);
                if (data0.equals(ColumnName)) {
                    colIndex = columnNumber;
                    //System.out.println("colIndex:" + colIndex);

                    //Finding test data using row and column id
                    rowCount=TestCaseID;
                    //System.out.println("Current row count:" + rowCount);
                    //System.out.println("Current column count:" + colIndex);
                    row = (Row) sheet.getRow(rowCount);
                    Cell cell1 = row.getCell(colIndex);
                    cell1.setCellType(CellType.STRING);
                    s = cell1.getStringCellValue();
                    s1 = s;
                    //System.out.println("Cell value is:" + s1);
                }
            }
        }

        return s1;
    }

}