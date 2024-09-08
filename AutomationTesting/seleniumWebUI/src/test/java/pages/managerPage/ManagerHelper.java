package pages.managerPage;

import org.openqa.selenium.WebDriver;

public class ManagerHelper {

    private WebDriver driver;
    private ManagerPO managerPO;

    public ManagerHelper(WebDriver driver) {
        this.driver = driver;
        this.managerPO = new ManagerPO(driver);
    }

    public void addCustomer() {
        managerPO.getAddCustomerButton().click();
    }

    public void openAccount() {
        managerPO.getOpenAccountLoginButton().click();
    }

    public void customers() {
        managerPO.getCustomersButton().click();
    }
}


