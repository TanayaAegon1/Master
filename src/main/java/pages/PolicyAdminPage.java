package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.resources.utils.Waits;

public class PolicyAdminPage {

    //All WebElements are identified by @FindBy annotation

    WebDriver driver;
    Waits wait=new Waits();

    @FindBy(xpath="//*[@id=\"B_1000\"]")
    WebElement createPolicyButton;


    public PolicyAdminPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    public void clickOnCreatePolicy(){
        wait.waitForElement(createPolicyButton, driver);
        createPolicyButton.click();
        System.out.println("Create policy page has opened..");
    }


}
