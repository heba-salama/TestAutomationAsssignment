package pages.customerListPage;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CustomerListHelper {

    private WebDriver driver;
    private CustomerListPO customerListPO;


    public CustomerListHelper(WebDriver driver) {
        this.driver = driver;
        this.customerListPO = new CustomerListPO(driver);
    }

    public void SearchForCustomer(String fName) {
        customerListPO.searchCustomerName().sendKeys(fName);
    }

    public String SearchResultText(String fName) {
        return customerListPO.findElementOfFirstNameInTable(fName).getText();
    }

    public void postCodeColumn() {
        customerListPO.getPostCodeColumn().click();
    }

    public void ascendingSortForPostCode() {
        List<String> postcodes = customerListPO.findElementsOfCustomerInTable().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedPostcodes = postcodes.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        assertEquals(postcodes, sortedPostcodes);
    }

    public void descendingSortForPostCode() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<String> postcodes = customerListPO.findElementsOfCustomerInTable().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedPostcodes = postcodes.stream()
                .sorted()
                .collect(Collectors.toList());
        assertEquals(postcodes, sortedPostcodes);
    }


    public String firstNameInTable() {
        return customerListPO.findElementsOfCustomerRow().get(1).getText();
    }


    public void deleteAndVerify() {
        String FirstCustomerName = firstNameInTable();

        if (!customerListPO.findElementsOfDeleteInTable().isEmpty()) {
            customerListPO.findElementsOfDeleteInTable().getFirst().click();
        }

        boolean customerExists = customerListPO.findElementsOfCustomerRow().stream()
                .anyMatch(element -> element.getText().equals(FirstCustomerName));

        assertFalse(customerExists);
    }


}

