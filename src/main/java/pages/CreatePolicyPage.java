package main.java.pages;

import main.resources.utils.Waits;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class CreatePolicyPage {

    //All WebElements are identified by @FindBy annotation
    WebDriver driver;
    Waits wait=new Waits();

    @FindBy(id="B10_1_1")
    WebElement productDropdownButton;

    @FindBy(id="T980")
    WebElement OKButton;

    @FindBy(id="B20_1_28")
    WebElement reasonForCreation;

    @FindBy(xpath="//button[@name='T981']")
    WebElement createNewPlanButton;

    @FindBy(id="T988")
    WebElement searchForCustomerButton;

    @FindBy(xpath="//*[@id='20_1_4']")
    WebElement surnameTextBox_SearchCustomer;

    @FindBy(id="986")
    WebElement searchButton_SearchCustomer;

    @FindBy(id="T982")
    WebElement backButton_SearchCustomer;

    @FindBy(id="20_1_1")
    WebElement policyIdentifier;

    @FindBy(id="20_1_2")
    WebElement policyNumber;

    @FindBy(id="20_1_3")
    WebElement dateOfEntry;

    @FindBy(id="20_1_4")
    WebElement policyTerm;

    @FindBy(id="B20_1_8")
    WebElement policyStatusDropdownButton;

    @FindBy(id="B20_1_9")
    WebElement policySubStatusDropdownButton;

    @FindBy(id="B20_1_12")
    WebElement qualifyingStatusDropdownButton;

    @FindBy(id="B20_1_14")
    WebElement taxReliefStatusDropdownButton;

    @FindBy(id="B20_1_16")
    WebElement lifeCoverBasisDropdownButton;

    @FindBy(id="B20_1_18")
    WebElement relationshipDropdownButton;

    @FindBy(id="20_1_19")
    WebElement ageAtEntry;

    @FindBy(id="20_1_24")
    WebElement withProfitSumAssured;

    @FindBy(id="20_1_23")
    WebElement initialSumAssured;

    @FindBy(id="B_984")
    WebElement createPolicyOKButton;

    @FindBy(id="T983")
    WebElement selectButton;

    @FindBy(id="T985")
    WebElement OKButton_CustomerScreen;

    @FindBy(id="30_1_12")
    WebElement premiumPaymentDate;

    @FindBy(id="B30_1_4")
    WebElement paymentFrequencyDropdownButton;

    @FindBy(id="30_1_5")
    WebElement premiumGrossAmount;

    @FindBy(id="30_1_14")
    WebElement employerPremiumGrossAmount;

    @FindBy(id="T979")
    WebElement OKButton_PremiumDetails;

    @FindBy(id="T981")
    WebElement OKButton_UnderwritingPage;

    @FindBy(id="05_1_2")
    WebElement policyNumber_MaintainBillingPage;

    @FindBy(id="05_1_1")
    WebElement policyIdentifier_MaintainBillingPage;

    @FindBy(id="10_1_3")
    WebElement billingPlanNumber_MaintainBillingPage;


    @FindBy(id="B20_1_5")
    WebElement collectionFrequency;

    @FindBy(id="T983")
    WebElement policyIdentifierLookupButton;

    @FindBy(id="20_1_1")
    WebElement billingPlanNumber;

    @FindBy(id="T980")
    WebElement OKButton_BillingPlanPage;



    public CreatePolicyPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    public void selectProductDropdownValue(String value) {
        wait.waitForElement(productDropdownButton,driver);
        productDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElement(By.xpath("//option[@value='"+value+"']")));
        Action action  = ob.build();
        action.perform();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        //System.out.println("Element clicked..");
    }

    public void clickOKButton() throws InterruptedException {
        Actions ob = new Actions(driver);
        ob.click(OKButton);
        Action action  = ob.build();
        action.perform();
        Thread.sleep(3000);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    }

    public void setReasonForCreationDropdownValue(String value){
        reasonForCreation.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        //System.out.println("Element clicked..");
    }

    public void clickCreateNewPlanButton(){
        Actions ob = new Actions(driver);
        ob.click(createNewPlanButton);
        Action action  = ob.build();
        action.perform();
    }

    public void clickSearchForCustomerButton() throws InterruptedException {
        wait.waitForElement(searchForCustomerButton,driver);
        Actions ob = new Actions(driver);
        ob.click(searchForCustomerButton);
        Action action  = ob.build();
        action.perform();
    }

    public void setSurnameTextBox_SearchCustomer(String value){
        wait.waitForElement(surnameTextBox_SearchCustomer,driver);
        surnameTextBox_SearchCustomer.click();
        surnameTextBox_SearchCustomer.sendKeys(value);
        System.out.println("Entered surname");
    }

    public void clickSearchButton_SearchCustomer() {
        wait.waitForElement(searchButton_SearchCustomer,driver);
        Actions ob = new Actions(driver);
        ob.click(searchButton_SearchCustomer);
        Action action  = ob.build();
        action.perform();
    }

    public void switchToIFrame()
    {
        driver.switchTo().frame("flow");
        System.out.println("Switched to frame..");
    }

    public void setPolicyIdentifier(String value)
    {
        wait.waitForElement(policyIdentifier,driver);
        Random rand = new Random();
        String rand_int1 = Integer.toString(rand.nextInt(1000));
        String rand_int2 = Integer.toString(rand.nextInt(1000));
        policyIdentifier.sendKeys(value+rand_int1+rand_int2);
    }

    public void setPolicyNumber()
    {
        Random rand = new Random();
        String rand_int1 = Integer.toString(rand.nextInt(1000));
        String rand_int2 = Integer.toString(rand.nextInt(1000));
        policyNumber.sendKeys(rand_int1+rand_int2);
    }

    public void setDateOfEntry(String value)
    {
        dateOfEntry.sendKeys(value.replace("'",""));
    }

    public void setPolicyTerm(String value)
    {
        policyTerm.sendKeys(value);
    }

    public void setPolicyStatusDropdownValue(String value)
    {
        policyStatusDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setPolicySubStatusDropdownValue(String value)
    {
        policySubStatusDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setQualifyingStatusDropdownValue(String value)
    {
        qualifyingStatusDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setTaxReliefStatusDropdownValue(String value)
    {
        taxReliefStatusDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setLifeCoverBasisDropdownValue(String value)
    {
        lifeCoverBasisDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setRelationshipDropdownValue(String value)
    {
        relationshipDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void setAgeAtEntry(String value)
    {
        ageAtEntry.click();
        ageAtEntry.sendKeys(value);
    }

    public void setInitialSumAssured(String value)
    {
        initialSumAssured.click();
        initialSumAssured.sendKeys(value);
    }

    public void setWithProfitSumAssured(String value)
    {
        withProfitSumAssured.click();
        withProfitSumAssured.sendKeys(value);
    }


    public void clickCreatePolicyOKButton()  {
        createPolicyOKButton.click();
    }

    public void selectCustomerByCustomerName(String value) throws InterruptedException {
        Thread.sleep(5000);
        //wait.waitForElement(driver.findElement(By.xpath("//*[text()='"+value+"']")),driver);
        driver.findElement(By.xpath("//*[text()='"+value+"']")).click();
    }

    public void clickSelectButton() throws InterruptedException {
        Actions ob = new Actions(driver);
        ob.click(selectButton);
        Action action  = ob.build();
        action.perform();
    }

    public void clickBackButton_SearchCustomer() throws InterruptedException {
        wait.waitForElement(backButton_SearchCustomer,driver);
        Actions ob = new Actions(driver);
        ob.click(backButton_SearchCustomer);
        Action action  = ob.build();
        action.perform();
    }

    public void clickOKButton_CustomerScreen() throws InterruptedException {
        wait.waitForElement(OKButton_CustomerScreen,driver);
        Actions ob = new Actions(driver);
        ob.click(OKButton_CustomerScreen);
        Action action  = ob.build();
        action.perform();
    }

    public void setPremiumPaymentDate(String value)
    {
        wait.waitForElement(premiumPaymentDate,driver);
        premiumPaymentDate.click();
        premiumPaymentDate.sendKeys(value);
    }

    public void setPremiumGrossAmount(String value)
    {
        premiumGrossAmount.click();
        premiumGrossAmount.sendKeys(value);
    }

    public void setEmployerPremiumGrossAmount(String value)
    {
        employerPremiumGrossAmount.click();
        employerPremiumGrossAmount.sendKeys(value);
    }

    public void setPaymentFrequencyDropdownValue(String value)
    {
        paymentFrequencyDropdownButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void clickOKButton_PremiumDetails() {
        Actions ob = new Actions(driver);
        ob.click(OKButton_PremiumDetails);
        Action action  = ob.build();
        action.perform();
    }

    public void clickOKButton_UnderwritingPage() {
        wait.waitForElement(OKButton_UnderwritingPage,driver);
        Actions ob = new Actions(driver);
        ob.click(OKButton_UnderwritingPage);
        Action action  = ob.build();
        action.perform();
    }

    public void getPolicyDetails()
    {
        wait.waitForElement(policyNumber_MaintainBillingPage,driver);
        String policyNumber= policyNumber_MaintainBillingPage.getText();
        String policyIdentifier=policyIdentifier_MaintainBillingPage.getText();
        String billingPlanNumber=billingPlanNumber_MaintainBillingPage.getText();
        System.out.println("Policy number="+policyNumber);
        System.out.println("Policy identifier="+policyIdentifier);
        System.out.println("Policy premium="+billingPlanNumber);
    }

    public void setCollectionFrequencyDropdownValue(String value)
    {
        wait.waitForElement(collectionFrequency,driver);
        collectionFrequency.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='"+value+"']")));
        //System.out.println("Element located..");
        Actions ob = new Actions(driver);
        ob.click(driver.findElements(By.xpath("//option[@value='"+value+"']")).get(0));
        Action action  = ob.build();
        action.perform();
        //System.out.println("Element clicked..");
    }

    public void clickPolicyIdentifierLookupButton()
    {
        Actions ob = new Actions(driver);
        ob.click(policyIdentifierLookupButton);
        Action action  = ob.build();
        action.perform();
    }

    public void setBillingPlanNumber(String value)
    {
        billingPlanNumber.sendKeys(value);
    }

    public void clickOKButton_BillingPlanPage() throws InterruptedException {
        wait.waitForElement(OKButton_BillingPlanPage,driver);
        Actions ob = new Actions(driver);
        ob.click(OKButton_BillingPlanPage);
        Action action  = ob.build();
        action.perform();
    }

    public String getPopUpMessage()
    {
        //wait.waitForTime(5,driver);
        driver.switchTo().frame("mymodalerr");
        System.out.println("Switched to frame..");
        Alert alert = driver.switchTo().alert();
        return driver.switchTo().alert().getText();
    }

    public void clickOKOnPopUpMessage()
    {
        Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().accept();
    }




}
