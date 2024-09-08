package pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPO {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By managerLoginButtonLocator = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    private final By customerLoginButtonLocator = By.xpath("//button[contains(text(),'Customer Login')]");
    private final By homeButtonLocator = By.xpath("//button[contains(text(),'Home')]");


    public LoginPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getManagerLoginButton() {
        return waitForVisible(managerLoginButtonLocator);
    }

    public WebElement getCustomerLoginButton() {
        return waitForVisible(customerLoginButtonLocator);
    }

    public WebElement getHomeButton() {
        return waitForVisible(homeButtonLocator);
    }

}

