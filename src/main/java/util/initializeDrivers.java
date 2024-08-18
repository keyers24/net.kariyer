package util;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class initializeDrivers {

    static WebDriver driver;
    static WebDriverWait wait;
    static String baseURL=ConfigReader.getProperty("URL");

    public static   WebDriver initializeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver =new ChromeDriver(options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseURL);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }
    public static synchronized WebDriver getDriver(){return driver;}


}
