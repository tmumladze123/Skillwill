package pagestep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.EnergoProHomePageObject;

public class EnergoProHomePageSteps {
    private EnergoProHomePageObject energoProHomePageObject;
    
    public EnergoProHomePageSteps(WebDriver driver, WebDriverWait wait) {
        energoProHomePageObject = new EnergoProHomePageObject(driver, wait);
    }

    public boolean waitUntilLoad() {
        return energoProHomePageObject.isPageLoaded();
    }
    
    public void searchText(String searchValue) {
        energoProHomePageObject.getSearchButton().click();
        energoProHomePageObject.getSearchInput().sendKeys(searchValue);
        energoProHomePageObject.getSearchInput().submit();
    }
    
    public boolean isPageDisplayed() {
        try {
            return energoProHomePageObject.getPhoneElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
