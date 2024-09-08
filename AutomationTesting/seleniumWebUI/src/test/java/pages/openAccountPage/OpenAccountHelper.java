package pages.openAccountPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountHelper {

    private WebDriver driver;
    private OpenAccountPO openAccountPO;

    public OpenAccountHelper(WebDriver driver) {
        this.driver = driver;
        this.openAccountPO = new OpenAccountPO(driver);
    }

    public void selectCustomer(String customer) {
        Select currencySelect = new Select(openAccountPO.customerSelect());
        currencySelect.selectByVisibleText(customer);
    }

    public void selectCurrency(String currency) {
        Select currencySelect = new Select(openAccountPO.currencySelect());
        currencySelect.selectByVisibleText(currency);
    }

    public void processButton() {
        openAccountPO.getProcessButton().click();
    }

}

