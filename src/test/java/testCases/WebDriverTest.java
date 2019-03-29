package test.java.testCases;

import main.resources.utils.ApplicationConstants;
import main.resources.utils.Waits;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class WebDriverTest {

    static WebDriver driver;
    Waits wait=new Waits();

    //public static WebDriver driver;
    ApplicationConstants applicationConstants = new ApplicationConstants();

    @BeforeClass
    public void start()
    {
    System.out.println("Starting class..");
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        //System.out.println("Step1");
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.get(applicationConstants.BaseURL);
        //System.out.println("Step2");
        //driver.manage().window().maximize();
        System.out.println("Browser launched and maximized..");
    }


    public void getScreenShot(String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/Users/Tanaya.Bardhan/IdeaProjects/SeleniumTestNG/TestScreenshots/" + fileName + ".png"));
    }


    @AfterMethod
    public void quit()
    {
        /*driver.close();
        driver.quit();*/
        System.out.println("Step1");
    }

    @AfterClass
    public void writeResultInExcel(ITestContext testContext) throws IOException, InterruptedException, AWTException {

        /*String file = "C:/Users/Tanaya.Bardhan/IdeaProjects/SeleniumTestNG/TestResult.xls";
        File f = new File(file);
        System.out.println("Step2");
        HSSFWorkbook workbook = new HSSFWorkbook();
        String classN=this.getClass().getName();
        System.out.println("Step3");
        String className = classN.substring(classN.indexOf("s."),classN.length()).replace("s.","");
        String[] columnNames = {"Sl. No.", "Module name","Test Case name", "Description","Time Taken","Execution Date","Result","Error message"};
        System.out.println("Step4");
        int colIndex = 0;
        HSSFSheet sheet=null;

        //Check if file already exists. If yes, delete and create. Else, only create.
        if (f.exists()&&applicationConstants.TestCaseCount==1) {
            f.delete();
            System.out.println("Deleted existing file..");

            FileOutputStream out = new FileOutputStream(new File("TestResult.xls"));
            System.out.println("Creating TestResult..");
            sheet = workbook.createSheet(className);
            //Filling out the column headers
            HSSFRow row = sheet.createRow((short) 0);
            for (int c = 0; c < 8; c++) {
                HSSFCell cell = row.createCell((short) c);
                //System.out.println("c is="+c);
                //System.out.println(columnNames[c]);
                cell.setCellValue(columnNames[c]);
            }
            System.out.println("Step5");
        }
        else if (f.exists()&&applicationConstants.TestCaseCount>1)
        {
            System.out.println("Writing in existing file..");
            sheet = workbook.getSheet(className);
            if(sheet.getSheetName()!=className)
            {
            sheet = workbook.createSheet(className);
            //Filling out the column headers
            HSSFRow row = sheet.createRow((short) 0);
            for (int c = 0; c < 8; c++) {
                HSSFCell cell = row.createCell((short) c);
                //System.out.println("c is="+c);
                //System.out.println(columnNames[c]);
                cell.setCellValue(columnNames[c]);
            }
            }
            System.out.println("Step6");
        }
        else{
            FileOutputStream out = new FileOutputStream(new File("TestResult.xls"));
            System.out.println("Creating TestResult..");
            sheet = workbook.createSheet(className);
            //Filling out the column headers
            HSSFRow row = sheet.createRow((short) 0);
            for (int c = 0; c < 8; c++) {
                HSSFCell cell = row.createCell((short) c);
                //System.out.println("c is="+c);
                //System.out.println(columnNames[c]);
                cell.setCellValue(columnNames[c]);
            }
            System.out.println("Step7");
        }

        //Getting test case count
       ITestNGMethod[] allMethods = testContext.getAllTestMethods();
        int testCaseCount=allMethods.length;
        System.out.println("Total test case count="+testCaseCount);
        for (int i=0;i<testCaseCount;i++) {
            System.out.println("Method names=" + allMethods);
        }
        //int currentIndex=1;
        //Filling out the data
        HSSFSheet sheet1 = workbook.getSheet(className);
        int rowCount;
        for (rowCount = applicationConstants.TestCaseCount; rowCount <applicationConstants.TestCaseCount+1;rowCount++) {
            HSSFRow row1 = sheet1.createRow((short) rowCount);
            System.out.println("Row count="+rowCount);

            //Filling index
            HSSFCell cell1 = row1.createCell((short) 0);
            cell1.setCellValue(Integer.toString(rowCount));

            //Filling module name
            cell1 = row1.createCell((short) 1);
            //String className = this.getClass().getName();
            System.out.println("Module name="+className);
            cell1.setCellValue(className);
            //cell1.setCellValue(String.valueOf(moduleName));

            //Filling test case name
            cell1 = row1.createCell((short) 2);
            //String methodName = method.getName();
            //System.out.println("Method name="+methodName);
            //cell1.setCellValue(methodName);

            //Filling execution date
            cell1 = row1.createCell((short) 5);
            String startDate = String.valueOf(testContext.getStartDate());
            System.out.println("Start date="+startDate);
            //cell1.setCellValue(methodName.substring(0, methodName.indexOf(".")));
            cell1.setCellValue(startDate);

            //Filling test result
            cell1 = row1.createCell((short) 2);
            /*int testResult = result.getStatus();
            if (testResult == 1) {
                cell1.setCellValue("PASSED");
                style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            else if (testResult == 2) {
                cell1.setCellValue("FAILED");
                /*style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            }
            else
            {
                cell1.setCellValue("SKIPPED");
                /*style = workbook.createCellStyle();
                style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                }*/

        /*}


        FileOutputStream fileOutputStream = new FileOutputStream(file);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        applicationConstants.TestCaseCount++;*/


        //Upload result file in sharepoint
       /*driver.get("https://sapiens365.sharepoint.com/LnP/CB/Shared%20Documents/Forms/AllItems.aspx?id=%2FLnP%2FCB%2FShared%20Documents%2FWesleyan%2FClosed%20Books%2FTest%2FTanayaTest");
       Thread.sleep(6000);
       WebElement upload = driver.findElement(By.xpath("//button[@name='Upload']"));
       upload.click();
        WebElement files = driver.findElement(By.name("Files"));
        files.click();
        Thread.sleep(4000);
        //files.sendKeys("C:/Users/Tanaya.Bardhan/IdeaProjects/SeleniumTestNG/TestResultTemplate");
        //Entering file path
        Robot rb =new Robot();
        rb.keyPress(KeyEvent.VK_C);
        rb.keyRelease(KeyEvent.VK_C);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        rb.keyPress(KeyEvent.VK_U);
        rb.keyRelease(KeyEvent.VK_U);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_R);
        rb.keyRelease(KeyEvent.VK_R);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_N);
        rb.keyRelease(KeyEvent.VK_N);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_Y);
        rb.keyRelease(KeyEvent.VK_Y);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_PERIOD);
        rb.keyRelease(KeyEvent.VK_PERIOD);
        rb.keyPress(KeyEvent.VK_B);
        rb.keyRelease(KeyEvent.VK_B);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_R);
        rb.keyRelease(KeyEvent.VK_R);
        rb.keyPress(KeyEvent.VK_D);
        rb.keyRelease(KeyEvent.VK_D);
        rb.keyPress(KeyEvent.VK_H);
        rb.keyRelease(KeyEvent.VK_H);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_N);
        rb.keyRelease(KeyEvent.VK_N);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        rb.keyPress(KeyEvent.VK_I);
        rb.keyRelease(KeyEvent.VK_I);
        rb.keyPress(KeyEvent.VK_D);
        rb.keyRelease(KeyEvent.VK_D);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_P);
        rb.keyRelease(KeyEvent.VK_P);
        rb.keyPress(KeyEvent.VK_R);
        rb.keyRelease(KeyEvent.VK_R);
        rb.keyPress(KeyEvent.VK_O);
        rb.keyRelease(KeyEvent.VK_O);
        rb.keyPress(KeyEvent.VK_J);
        rb.keyRelease(KeyEvent.VK_J);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_C);
        rb.keyRelease(KeyEvent.VK_C);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_L);
        rb.keyRelease(KeyEvent.VK_L);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_N);
        rb.keyRelease(KeyEvent.VK_N);
        rb.keyPress(KeyEvent.VK_I);
        rb.keyRelease(KeyEvent.VK_I);
        rb.keyPress(KeyEvent.VK_U);
        rb.keyRelease(KeyEvent.VK_U);
        rb.keyPress(KeyEvent.VK_M);
        rb.keyRelease(KeyEvent.VK_M);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_N);
        rb.keyRelease(KeyEvent.VK_N);
        rb.keyPress(KeyEvent.VK_G);
        rb.keyRelease(KeyEvent.VK_G);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_R);
        rb.keyRelease(KeyEvent.VK_R);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_S);
        rb.keyRelease(KeyEvent.VK_S);
        rb.keyPress(KeyEvent.VK_U);
        rb.keyRelease(KeyEvent.VK_U);
        rb.keyPress(KeyEvent.VK_L);
        rb.keyRelease(KeyEvent.VK_L);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        rb.keyPress(KeyEvent.VK_M);
        rb.keyRelease(KeyEvent.VK_M);
        rb.keyPress(KeyEvent.VK_P);
        rb.keyRelease(KeyEvent.VK_P);
        rb.keyPress(KeyEvent.VK_L);
        rb.keyRelease(KeyEvent.VK_L);
        rb.keyPress(KeyEvent.VK_A);
        rb.keyRelease(KeyEvent.VK_A);
        rb.keyPress(KeyEvent.VK_T);
        rb.keyRelease(KeyEvent.VK_T);
        rb.keyPress(KeyEvent.VK_E);
        rb.keyRelease(KeyEvent.VK_E);
        Thread.sleep(2000);


        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        System.out.println("File uploaded!!");*/


    }




}
