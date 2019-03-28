package main.java.pages;

import main.resources.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

     //All WebElements are identified by @FindBy annotation

    WebDriver driver;
    Waits wait=new Waits();

    @FindBy(xpath="//div[text()='Logon Form']")
    WebElement pageTitle;

    @FindBy(xpath="//input[@id='user']")
    WebElement userID;

    @FindBy(xpath="//input[@type='text]")
    WebElement application;

    @FindBy(xpath="//input[@id='Ok_btn']")
    WebElement OKButton;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    public String getPageTitle() throws InterruptedException {
        String s;
        //System.out.println("Finding element..");
        wait.waitForElement(pageTitle,driver);
        s=pageTitle.getText();
        return s;
    }

    public void setUserID(String ID){
        userID.sendKeys(ID);
    }

    public void setApplication(String ID){
        application.sendKeys(ID);
    }

    public void clickOKButton(){
        OKButton.click();
        //wait.waitForTime(2,driver);
    }


}
