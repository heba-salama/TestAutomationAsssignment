Feature: Banking Application

  Scenario:  1-Create new customer
    Given Login as Bank manager to the website
    When Add customer "Heba" "Elsayed" "0000"
    Then Validate the creation success message "Customer added successfully with customer id:"


  Scenario Outline:  2-Open a new account
    Given Login as Bank manager to the website
    When Open account for customer "<Customer>" with currency "Dollar"
    And  Validate the creation success message "Account created successfully with account Number :"
    * Login in with Customer "<Customer>"
    Then Validate the bank account Added successfully
    Examples:
      | Customer     |
      | Harry Potter |

  Rule: the user is in the Bank manger page

    Background:Bank Manger is logged in
      Given Login as Bank manager to the website

        Scenario Outline:  3-Search on an exist customer by firstName
        When Search for valid customer "<Customer>"
        Then Validate "<Customer>" found in the list

        Examples:
          | Customer |
          | Harry    |


        Scenario:  4-Sort the customers by PostalCode
          When I sort customers by postcode in ascending order
          Then Validate the customers sorted correctly in ascending order
          When I sort customers by postcode in descending order
          Then Validate the customers sorted correctly in descending order


        Scenario:  5-Bonus: Delete Customer
          Then Delete and verify the first Customer has been deleted successfully
