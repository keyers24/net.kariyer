package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.homePage;

import java.time.Duration;

import static util.initializeDrivers.getDriver;

public class homePageTest extends baseTest{

    WebDriver driver;
    WebDriverWait wait;
    homePage homePage;
    baseTest baseTest;

    public homePageTest() {
       this.baseTest=new baseTest();
       this.driver=getDriver();
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       this.homePage=new homePage(driver,wait);
    }

    @Test
    @DisplayName("Home Page Test Scenario")
    public void checkHomePage(){
        Assertions.assertEquals(driver.getCurrentUrl(),"https://www.kariyer.net/");
        baseTest.checkElement(homePage.checkLogo);
        baseTest.click(basePage.btnCopilot);

    }
}
