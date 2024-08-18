package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class basePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public basePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//img[@class='kp-close-button']")
    public WebElement btnCopilot;


}
