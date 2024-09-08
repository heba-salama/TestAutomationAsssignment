package pages.customerListPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerListPO {

    private WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By searchCustomerLocator = By.xpath("//input[@placeholder='Search Customer']");
    private final By posCodeColumnLocator = By.linkText("Post Code");


    public CustomerListPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement searchCustomerName() {
        return waitForVisible(searchCustomerLocator);
    }

    public WebElement getPostCodeColumn() {
        return waitForVisible(posCodeColumnLocator);
    }

    public WebElement findElementOfFirstNameInTable(String customerName) {
        return waitForVisible(By.xpath("//table//td[contains(text(),'" + customerName + "')])"));
    }

    public List<WebElement> findElementsOfCustomerInTable() {
        return driver.findElements(By.xpath("//table//tr[position()>1]/td[3]"));
    }

    public List<WebElement> findElementsOfDeleteInTable() {
        return driver.findElements(By.xpath("//button[text()='Delete']"));
    }

    public List<WebElement> findElementsOfCustomerRow() {
        return driver.findElements(By.xpath("//tr/td[1]"));
    }


}

