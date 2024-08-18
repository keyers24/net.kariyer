package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;
import util.ConfigReader;

import java.time.Duration;
import java.util.logging.Logger;

import static util.initializeDrivers.getDriver;

public class loginPageTest extends baseTest{
    WebDriver driver;
    WebDriverWait wait;
    pages.loginPage loginPage;
    baseTest baseTest;
    private static final Logger log = Logger.getLogger("loginPageTest");
    public loginPageTest() {
        this.baseTest=new baseTest();
        this.driver=getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage= new loginPage(driver,wait);
    }
    @Test
    @DisplayName("Success Login Scenario")
    public void login(){
        baseTest.click(loginPage.btnLoginAndSignin);
        baseTest.click(loginPage.btnLogin);
        baseTest.senKeyElement(loginPage.txtUsername,ConfigReader.getProperty("userName"));
        baseTest.senKeyElement(loginPage.txtPass,ConfigReader.getProperty("pass"));
        baseTest.click(loginPage.btnSubmit);
        log.info("Lütfen CAPTCHA'yı manuel olarak çözün...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        baseTest.click(loginPage.btnGuideClose);
        baseTest.click(loginPage.btnClose);
        baseTest.click(loginPage.dropDown);
        baseTest.click(loginPage.btnExit);

    }
}
