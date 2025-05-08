package energopro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleEnergoProTest {
    public static void main(String[] args) {
        System.out.println("Starting simple Energo Pro test...");
        
        // Set up Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize WebDriver without WebDriverManager
        WebDriver driver = null;
        
        try {
            // Create a new ChromeDriver instance
            driver = new ChromeDriver(options);
            
            // Create a WebDriverWait with 10 second timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Navigate to Energo Pro website
            System.out.println("Navigating to Energo Pro website...");
            driver.get("https://energo-pro.ge");
            
            // Add a small delay to ensure page starts loading
            Thread.sleep(2000);
            
            // Print the title of the page
            System.out.println("Page title: " + driver.getTitle());
            
            // Check if we can find an element on the page
            boolean elementFound = !driver.findElements(By.xpath("//*[@class = 'calls container wow fadeIn']//span")).isEmpty();
            System.out.println("Element found: " + elementFound);
            
            System.out.println("Test completed successfully!");
        } catch (Exception e) {
            System.out.println("Test failed with exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
