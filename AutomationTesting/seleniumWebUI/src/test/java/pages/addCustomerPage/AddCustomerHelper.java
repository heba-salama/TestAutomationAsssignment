package pages.addCustomerPage;

import org.openqa.selenium.*;

public class AddCustomerHelper {

    private WebDriver driver;
    private AddCustomerPO addCustomerPO;


    public AddCustomerHelper(WebDriver driver) {
        this.driver = driver;
        this.addCustomerPO = new AddCustomerPO(driver);
    }

    public void firstName(String fName) {
        addCustomerPO.getfName().sendKeys(fName);
    }

    public void lastName(String lName) {
        addCustomerPO.getlName().sendKeys(lName);
    }

    public void postCode(String postCode) {
        addCustomerPO.getPostCode().sendKeys(postCode);
    }

    public void addCustomerButton() {
        addCustomerPO.getAddCustomerButton().click(); // Use method to get the WebElement
    }

    public String alertTextAndAccept() {

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        try {
            alert.accept();
            driver.switchTo().defaultContent();
            return alertText;
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
        return alertText;
    }

}

