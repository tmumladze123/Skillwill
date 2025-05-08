package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.time.Duration;

import static base.data.Const.*;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    
    public BaseClass() {
        // Setup ChromeDriver with appropriate options
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize the driver with options
        driver = new ChromeDriver(options);
        
        // Initialize WebDriverWait with a reasonable timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void openEnergoPro() {
        driver.get(energoProBaseLink);
        // Add a small delay to ensure page starts loading
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void openEnergoProPersonalSite() {
        driver.get(energoProPersonalLink);
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
