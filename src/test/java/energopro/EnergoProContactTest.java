package energopro;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagestep.EnergoProHomePageSteps;

import java.util.List;

public class EnergoProContactTest extends BaseClass {

    private EnergoProHomePageSteps energoProHomePageSteps;

    @BeforeMethod
    public void setUp() {
        energoProHomePageSteps = new EnergoProHomePageSteps(driver, wait);
    }

    @Test
    public void checkPhoneNumberSelenium() {
        openEnergoPro();
        boolean isLoaded = energoProHomePageSteps.waitUntilLoad();
        Assert.assertTrue(isLoaded, "Energo Pro page failed to load");
        energoProHomePageSteps.searchText("service");
    }

//    @Test
//    public void checkEnergyStopDates() {
//        driver.get("https://energo-pro.ge/ow/#/");
//        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//*[@class='footer-info-top']")));
//
//        List<WebElement> elements = driver.findElements(
//            By.xpath("//b[text()='ახმეტა']/parent::*/parent::*/following-sibling::*/div/div"));
//        for (WebElement element : elements) {
//            System.out.println(element.getText());
//        }
//    }
}
