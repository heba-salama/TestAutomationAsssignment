package stepDef;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.addCustomerPage.AddCustomerHelper;
import pages.customerListPage.CustomerListHelper;
import pages.customerPage.CustomerHelper;
import pages.loginPage.LoginHelper;
import org.openqa.selenium.WebDriver;
import pages.managerPage.ManagerHelper;
import pages.openAccountPage.OpenAccountHelper;

public class BankingProjectStepDef {

    private WebDriver driver;
    private LoginHelper loginHelper;
    private ManagerHelper managerHelper;
    private AddCustomerHelper addCustomerHelper;
    private OpenAccountHelper openAccountHelper;
    private CustomerHelper customerHelper;
    private CustomerListHelper customerListHelper;

    public BankingProjectStepDef() {
        this.driver = Hooks.getDriver();
        this.loginHelper = new LoginHelper(driver);
        this.managerHelper = new ManagerHelper(driver);
        this.addCustomerHelper = new AddCustomerHelper(driver);
        this.openAccountHelper = new OpenAccountHelper(driver);
        this.customerHelper = new CustomerHelper(driver);
        this.customerListHelper = new CustomerListHelper(driver);
    }

    @Given("Login as Bank manager to the website")
    public void loginAsBankManager() {
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        loginHelper.homeButton();
        loginHelper.loginBankManager();
    }

    @And("Add customer {string} {string} {string}")
    public void addCustomer(String fName, String lName, String postCode) {

        managerHelper.addCustomer();
        addCustomerHelper.firstName(fName);
        addCustomerHelper.lastName(lName);
        addCustomerHelper.postCode(postCode);
        addCustomerHelper.addCustomerButton();
    }


    @Then("Validate the creation success message {string}")
    public void validateTheCreationSuccessMessage(String successMessage) {
        assert addCustomerHelper.alertTextAndAccept().contains(successMessage);
    }

    @And("Open account for customer {string} with currency {string}")
    public void openAccountForCustomerWithCurrency(String customer, String currency) {
        managerHelper.openAccount();
        openAccountHelper.selectCustomer(customer);
        openAccountHelper.selectCurrency(currency);
        openAccountHelper.processButton();

    }

    @When("Login in with Customer {string}")
    public void loginInWithCustomer(String customer) throws InterruptedException {
        loginHelper.homeButton();
        loginHelper.loginCustomer();
        customerHelper.selectCustomer(customer);
        customerHelper.loginButton();
    }

    @Then("Validate the bank account Added successfully")
    public void validateTheBankAccountAddedSuccessfully() {
    }


    @And("Search for valid customer {string}")
    public void searchForValidCustomer(String customerName) {
        managerHelper.customers();
        customerListHelper.SearchForCustomer(customerName);
    }

    @Then("Validate {string} found in the list")
    public void validateFoundInTheList(String customerName) {
        assert customerListHelper.SearchResultText(customerName).contains(customerName);
    }

    @Given("I sort customers by postcode in ascending order")
    public void iSortCustomersByPostcodeInAscendingOrder() {
        managerHelper.customers();
        customerListHelper.postCodeColumn();

    }

    @Then("Validate the customers sorted correctly in ascending order")
    public void validateTheCustomersSortedCorrectlyInAscendingOrder() {
        customerListHelper.ascendingSortForPostCode();
    }

    @Given("I sort customers by postcode in descending order")
    public void iSortCustomersByPostcodeInDescendingOrder() {
        customerListHelper.postCodeColumn();
    }

    @Then("Validate the customers sorted correctly in descending order")
    public void validateTheCustomersSortedCorrectlyInDescendingOrder() {
        customerListHelper.descendingSortForPostCode();
    }


    @When("Delete and verify the first Customer has been deleted successfully")
    public void deleteAndVerifyTheFirstCustomerHasBeenDeletedSuccessfully() {
        managerHelper.customers();
        customerListHelper.deleteAndVerify();
    }
}

