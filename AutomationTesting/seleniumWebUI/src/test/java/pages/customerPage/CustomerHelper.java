package pages.customerPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerHelper {

    private WebDriver driver;
    private CustomerPO customerPO;

    public CustomerHelper(WebDriver driver) {
        this.driver = driver;
        this.customerPO = new CustomerPO(driver);
    }

    public void selectCustomer(String customer) {
        Select currencySelect = new Select(customerPO.customerSelect());
        currencySelect.selectByVisibleText(customer);
    }


    public void loginButton() {
        customerPO.getLoginButton().click();
    }
}

