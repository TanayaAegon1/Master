package test.java.testCases;

import main.java.pages.CreatePolicyPage;
import main.java.pages.HomePage;
import main.java.pages.LoginPage;
import main.java.pages.PolicyAdminPage;
import main.resources.utils.ReadDataFromExcel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


public class PolicyAdminTest extends WebDriverTest{

    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    String ExcelTabName="PolicyAdmin";

    @Test(description = "Verify if user is able to create policy")
    public void createPolicy() throws IOException, InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        //Thread.sleep(5000);
        String pageTitle = loginPage.getPageTitle();
        System.out.println("Page Title=" + pageTitle);
        loginPage.setUserID(readDataFromExcel.readExcel(1,"User ID", ExcelTabName));
        loginPage.clickOKButton();

        HomePage homePage=new HomePage(driver);
        Thread.sleep(5000);
        homePage.switchToIFrame();
        homePage.sapiensLogoIsDisplayed();
        homePage.clickOnPolicyAdminTab();

        PolicyAdminPage policyAdminPage=new PolicyAdminPage(driver);
        policyAdminPage.clickOnCreatePolicy();

        CreatePolicyPage createPolicyPage=new CreatePolicyPage(driver);
        createPolicyPage.selectProductDropdownValue(readDataFromExcel.readExcel(1,"Product", ExcelTabName));
        createPolicyPage.clickOKButton();

        createPolicyPage.setPolicyIdentifier(readDataFromExcel.readExcel(1,"Policy Identifier", ExcelTabName));
        createPolicyPage.setPolicyNumber();
        createPolicyPage.setDateOfEntry(readDataFromExcel.readExcel(1,"Date Of Entry", ExcelTabName));
        createPolicyPage.setPolicyTerm(readDataFromExcel.readExcel(1,"Policy Term", ExcelTabName));
        createPolicyPage.setPolicyStatusDropdownValue(readDataFromExcel.readExcel(1,"Policy Status", ExcelTabName));
        createPolicyPage.setPolicySubStatusDropdownValue(readDataFromExcel.readExcel(1,"Policy SubStatus", ExcelTabName));
        createPolicyPage.setQualifyingStatusDropdownValue(readDataFromExcel.readExcel(1,"Qualifying Status", ExcelTabName));
        createPolicyPage.setTaxReliefStatusDropdownValue(readDataFromExcel.readExcel(1,"Tax-Relief Status", ExcelTabName));
        createPolicyPage.setLifeCoverBasisDropdownValue(readDataFromExcel.readExcel(1,"Life Cover Basis", ExcelTabName));
        createPolicyPage.setRelationshipDropdownValue(readDataFromExcel.readExcel(1,"Relationship", ExcelTabName));
        createPolicyPage.setAgeAtEntry(readDataFromExcel.readExcel(1,"Age At Entry", ExcelTabName));
        createPolicyPage.setInitialSumAssured(readDataFromExcel.readExcel(1,"Initial Sum Assured", ExcelTabName));
        createPolicyPage.setWithProfitSumAssured(readDataFromExcel.readExcel(1,"With Profit Sum Assured", ExcelTabName));
        createPolicyPage.setReasonForCreationDropdownValue(readDataFromExcel.readExcel(1,"Reason for Creation", ExcelTabName));
        createPolicyPage.clickCreatePolicyOKButton();

        createPolicyPage.clickSearchForCustomerButton();
        createPolicyPage.setSurnameTextBox_SearchCustomer(readDataFromExcel.readExcel(1,"Surname",ExcelTabName));
        createPolicyPage.clickSearchButton_SearchCustomer();
        createPolicyPage.selectCustomerByCustomerName(readDataFromExcel.readExcel(1,"Customer Name", ExcelTabName));
        createPolicyPage.clickSelectButton();
        createPolicyPage.clickBackButton_SearchCustomer();
        createPolicyPage.clickOKButton_CustomerScreen();

        createPolicyPage.setPremiumPaymentDate(readDataFromExcel.readExcel(1,"Premium Payment Date",ExcelTabName));
        createPolicyPage.setPaymentFrequencyDropdownValue(readDataFromExcel.readExcel(1,"Premium Frequency",ExcelTabName));
        createPolicyPage.setPremiumGrossAmount(readDataFromExcel.readExcel(1,"Premium Gross Amount",ExcelTabName));
        createPolicyPage.setEmployerPremiumGrossAmount(readDataFromExcel.readExcel(1,"Employer Premium Gross Amount",ExcelTabName));
        createPolicyPage.clickOKButton_PremiumDetails();

        createPolicyPage.clickOKButton_UnderwritingPage();

        createPolicyPage.setCollectionFrequencyDropdownValue(readDataFromExcel.readExcel(1,"Collection Frequency",ExcelTabName));
        createPolicyPage.setBillingPlanNumber(readDataFromExcel.readExcel(1,"Billing Plan Number",ExcelTabName));
        createPolicyPage.clickOKButton_BillingPlanPage();

        createPolicyPage.getPolicyDetails();
        getScreenShot("createPolicy");
        System.out.println(createPolicyPage.getPopUpMessage());
        createPolicyPage.clickOKOnPopUpMessage();
        homePage.clickExitButton();
        //driver.close();
    }
}