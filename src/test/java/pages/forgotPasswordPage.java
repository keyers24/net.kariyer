package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class forgotPasswordPage extends basePage {


    public forgotPasswordPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(id = "forgottenPassLink")
    public WebElement btnForgotPass;
    @FindBy(id = "email")
    public WebElement txtEmail;
    @FindBy(css = ".submit-button")
    public WebElement submitForgotPass;
    @FindBy(css = "div[class='forgot-password-container'] h1")
    public WebElement checkText;
}
