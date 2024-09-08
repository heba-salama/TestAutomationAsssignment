package pages.managerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManagerPO {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By addCustomerButtonLocator = By.xpath("//button[contains(text(),'Add Customer')]");
    private final By openAccountButtonLocator = By.xpath("//button[contains(text(),'Open Account')]");
    private final By customersButtonLocator = By.xpath("//button[contains(text(),'Customers')]");


    public ManagerPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getAddCustomerButton() {
        return waitForVisible(addCustomerButtonLocator);
    }

    public WebElement getOpenAccountLoginButton() {
        return waitForVisible(openAccountButtonLocator);
    }

    public WebElement getCustomersButton() {
        return waitForVisible(customersButtonLocator);
    }

}

