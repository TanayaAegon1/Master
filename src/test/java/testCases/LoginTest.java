package test.java.testCases;

import main.java.pages.HomePage;
import main.java.pages.LoginPage;
import main.resources.utils.ReadDataFromExcel;
import main.resources.utils.ApplicationConstants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class LoginTest extends WebDriverTest{


    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    ApplicationConstants applicationConstants = new ApplicationConstants();
    String ExcelTabName="LoginPage";

    //@Test(description = "Verify if user is able to login to Aegon")
    @Test
    public void loginToAegon() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String pageTitle = loginPage.getPageTitle();
        assertEquals(pageTitle,applicationConstants.LoginPageTitle);
        loginPage.setUserID(readDataFromExcel.readExcel(1, "User ID", ExcelTabName));
        loginPage.clickOKButton();

        HomePage homePage=new HomePage(driver);
        homePage.switchToIFrame();
        assertTrue(homePage.sapiensLogoIsDisplayed());
        getScreenShot("loginToAegon");
        homePage.clickExitButton();
    }

}
