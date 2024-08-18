package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage{
    public loginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    @FindBy(css = ".user > [data-test='title']")
    public WebElement btnLoginAndSignin;
    @FindBy(css = ".header-user-items-menu-button.empty-button.login-button")
    public WebElement btnLogin;
    @FindBy(id="username")
    public WebElement txtUsername;
    @FindBy(id="pass")
    public WebElement txtPass;
    @FindBy(css="[data-test=\"login-button\"]")
    public WebElement btnSubmit;
    @FindBy(css=".material-icons.k-guide-close-icon")
    public WebElement btnGuideClose;
    @FindBy(css=".close")
    public WebElement btnClose;
    @FindBy(css=".arrow-icon.material-icons")
    public WebElement dropDown;
    @FindBy(css=".header-nav-items-menu-item-title[href='/aday/cikis']")
    public WebElement btnExit;

}
