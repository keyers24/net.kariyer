package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.forgotPasswordPage;
import pages.homePage;
import pages.loginPage;
import util.ConfigReader;

import java.time.Duration;
import java.util.logging.Logger;

import static util.initializeDrivers.getDriver;

public class forgotPasswordPageTest extends baseTest{
    WebDriver driver;
    WebDriverWait wait;
    pages.loginPage loginPage;
    pages.forgotPasswordPage forgotPasswordPage;
    baseTest baseTest;

    private static final Logger log = Logger.getLogger("forgotPasswordPageTest");
    public forgotPasswordPageTest() {
        this.baseTest=new baseTest();
        this.driver=getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage=new loginPage(driver,wait);
        this.forgotPasswordPage=new forgotPasswordPage(driver,wait);
    }

    @Test
    @DisplayName("Forgot Password Test Scenario")
    public void ForgotPassword(){
        baseTest.click(loginPage.btnLoginAndSignin);
        baseTest.click(loginPage.btnLogin);
        baseTest.click(forgotPasswordPage.btnForgotPass);
        baseTest.senKeyElement(forgotPasswordPage.txtEmail, ConfigReader.getProperty("userName"));
        baseTest.click(forgotPasswordPage.submitForgotPass);
        log.info("Lütfen CAPTCHA'yı manuel olarak çözün...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        baseTest.checkElement(forgotPasswordPage.checkText);
    }
}
