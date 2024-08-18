package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage;
import java.io.*;
import static util.initializeDrivers.getDriver;
import static util.initializeDrivers.initializeDriver;
import java.time.Duration;
import java.util.logging.Logger;

public class baseTest {

    static WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    basePage basePage;

    private static final Logger log = Logger.getLogger("baseTest");
    public baseTest() {
        this.driver = getDriver();
        this.actions = new Actions(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        basePage=new basePage(driver,wait);
    }

    public  boolean isDisplayed(WebElement element){
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public  void senKeyElement(WebElement key, String text){
        WebElement element=checkElement(key);
        element.sendKeys(text);
    }

    public WebElement checkElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void pressEnter(WebElement Element){
        WebElement element=checkElement(Element);
        element.sendKeys(Keys.ENTER);
    }
    public void clearText(WebElement Element){
        WebElement element=checkElement(Element);
        element.sendKeys();
    }

    public  void click(WebElement Element){
        WebElement element=checkElement(Element);
        element.click();
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }
    public void getWindowHandle(){
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }


    @BeforeClass
    public static void before(){
        driver=initializeDriver();
        log.info("Driver İnitialize");

    }
    @AfterClass
    public static void tearDown(){driver.quit();log.info("Driver Quit");}
}
