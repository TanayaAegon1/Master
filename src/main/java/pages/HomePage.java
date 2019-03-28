package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.resources.utils.Waits;

public class HomePage {

    //All WebElements are identified by @FindBy annotation

    WebDriver driver;
    Waits wait=new Waits();

    @FindBy(id="9019")
    WebElement sapiensLogo;

    @FindBy(xpath="//input[@id='95_1_2']")
    WebElement policyAdminTab;

    @FindBy(xpath="//div[@id='TL20_1_39']")
    WebElement SurnamePrefix;

    @FindBy(id="95_1_11")
    WebElement exitButton;


    public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    public boolean sapiensLogoIsDisplayed(){
        wait.waitForElement(sapiensLogo, driver);
        return sapiensLogo.isDisplayed();
    }

    public void clickOnPolicyAdminTab(){
        wait.waitForElement(policyAdminTab,driver);
        policyAdminTab.click();
        System.out.println("Policy Admin Tab has opened..");
    }

    public String getSurnamePrefixText(){
        return SurnamePrefix.getText();
    }

    public void switchToIFrame() {
        driver.switchTo().frame("flow");
        System.out.println("Switched to frame..");
    }

    public void clickExitButton() throws InterruptedException {
        wait.waitForElement(exitButton,driver);
        exitButton.click();
        Thread.sleep(5000);
    }
}
