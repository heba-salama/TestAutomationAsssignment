package pages.customerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPO {

    private WebDriver driver;
    private final WebDriverWait wait;


    // Locators
    private final By customersDropDownLocator = By.id("userSelect");
    private final By loginButtonLocator = By.xpath("//button[text()='Login']");


    public CustomerPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement customerSelect() {
        return waitForVisible(customersDropDownLocator);
    }


    public WebElement getLoginButton() {
        return waitForVisible(loginButtonLocator);
    }

}

