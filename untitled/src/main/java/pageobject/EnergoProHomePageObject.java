package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnergoProHomePageObject {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Element locators
    private final By searchInputLocator = By.xpath("//*[@placeholder='საძიებო ფრაზა']");
    private final By searchButtonLocator = By.xpath("//*[@class='search-form']/div");
    private final By phoneElementLocator = By.xpath("//*[@class = 'calls container wow fadeIn']//span");
    
    public EnergoProHomePageObject(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public WebElement getSearchInput() {
        return  driver.findElement(searchInputLocator);
    }
    
    public WebElement getSearchButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
    }
    
    public WebElement getPhoneElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneElementLocator));
    }
    
    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(phoneElementLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
