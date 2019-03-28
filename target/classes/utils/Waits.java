package main.resources.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class Waits {
    WebDriver driver;

    public void waitForElement(WebElement element,WebDriver driver ) {

        if (element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOf(element));
                //System.out.println("Element found!!");

            } catch (Exception e) {
                System.out.println("Element not found!!");

            }
        } else
            System.out.println("Element does not exist");

    }

    /*public void waitForTime(int time, WebDriver driver)
    {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }*/

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        System.out.println("Page loading complete...");
    }
}
