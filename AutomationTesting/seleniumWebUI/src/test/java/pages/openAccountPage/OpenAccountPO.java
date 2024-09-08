package pages.openAccountPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenAccountPO {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By customersDropDownLocator = By.id("userSelect");
    private final By currencyDropDownLocator = By.id("currency");
    private final By processButtonLocator = By.xpath("//button[text()='Process']");


    public OpenAccountPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement customerSelect() {
        return waitForVisible(customersDropDownLocator);
    }

    public WebElement currencySelect() {
        return waitForVisible(currencyDropDownLocator);
    }

    public WebElement getProcessButton() {
        return waitForVisible(processButtonLocator);
    }

}

