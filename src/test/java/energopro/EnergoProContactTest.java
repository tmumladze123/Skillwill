package energopro;

import base.BaseClass;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EnergoProContactTest  extends BaseClass {

    @Test
    public void checkPhoneNumberSelenium()  {
        openEnergoPro();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'calls container wow fadeIn']//span")));
        WebElement searchInput = driver.findElement(By.xpath("//*[@placeholder='საძიებო ფრაზა']"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@class='search-form']/div"));
        searchButton.click();
        searchInput.sendKeys("service");
        searchInput.submit();
    }
    @Test
    public void checkEnergyStopDatesSelenide()  {
        openEnergoProPersonalSite();
        $(By.xpath("//*[@class='footer-info-top']")).scrollTo();
        ElementsCollection elements = $$(By.xpath("//b[text()='ახმეტა']/parent::*/parent::*/following-sibling::*/div/div"));
        elements.stream()
                .map(SelenideElement::getText)
                .forEach(System.out::println);
    }


}
