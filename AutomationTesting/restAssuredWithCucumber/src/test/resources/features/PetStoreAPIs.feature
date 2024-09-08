Feature: Pet Store APIs

  Scenario: Getting details of a pet by ID
    When I request find pet by ID "2"
    And Validate the status code is 200
    Then Validate the returned Pet's name is "CatTest"


  Scenario: Getting All Pets by Status
    Given I request find pets by status "pending"
    And Validate the status code is 200
    Then Validate all the returned pets with status "pending"

  Scenario Outline: Create a New Pet
    Given Add a new Pet with name "<Pet Name>"
    And Validate the status code is 200
    Then Validate the pet "<Pet Name>" created successfully
    Examples:
      | Pet Name |
      | Bird     |
