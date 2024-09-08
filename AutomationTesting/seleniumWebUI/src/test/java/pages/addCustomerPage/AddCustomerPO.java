package pages.addCustomerPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomerPO {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By fNameLocator = By.xpath("//input[@ng-model='fName']");
    private final By lNameLocator = By.xpath("//input[@ng-model='lName']");
    private final By postCodeLocator = By.xpath("//input[@ng-model='postCd']");
    private final By addCustomerButtonLocator = By.xpath("//button[text()='Add Customer']");
    public final By alertLocator = By.xpath("//div[@class='alert']");


    public AddCustomerPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForInVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement getfName() {
        return waitForVisible(fNameLocator);
    }

    public WebElement getlName() {
        return waitForVisible(lNameLocator);
    }

    public WebElement getPostCode() {
        return waitForVisible(postCodeLocator);
    }

    public WebElement getAddCustomerButton() {
        return waitForVisible(addCustomerButtonLocator);
    }


}

