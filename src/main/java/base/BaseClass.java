package base;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;
import static data.Const.energoPro;
import static data.Const.energoProPersonalLink;

public class BaseClass {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }
    public void openEnergoPro(){
        driver.get(energoPro);
    }
    public void openEnergoProPersonalSite(){
        open(energoProPersonalLink);
    }

    @AfterClass
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
