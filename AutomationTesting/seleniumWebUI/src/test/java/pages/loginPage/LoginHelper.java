package pages.loginPage;

import org.openqa.selenium.WebDriver;

public class LoginHelper {

    private WebDriver driver;
    private LoginPO loginPO;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPO = new LoginPO(driver); // Initialize LoginPO with WebDriver
    }

    public void loginCustomer() {
        loginPO.getCustomerLoginButton().click(); // Use method to get the WebElement
    }

    public void loginBankManager() {
        loginPO.getManagerLoginButton().click(); // Use method to get the WebElement
    }

    public void homeButton() {
        loginPO.getHomeButton().click(); // Use method to get the WebElement
    }
}

