# Automation API Project

## Project Overview

This project is a Java-based automation suite for API testing using Cucumber, JUnit, and Allure for reporting. It is designed to test the Pet Store APIs.

## Project Structure

* automationAPI
* │
* ├── src
* │   └── test
* │       ├── java
* │       │   ├── stepDef
* │       │     └── PetStoreStepDef.java  # Step definitions for Cucumber scenarios
* │       └── resources
* │           ├── features
* │             └── petstore.feature  # Feature files for Cucumber* │
* ├── target
* │   ├── cucumber-reports
* │   └── (Generated test reports and compiled classes)
* │
* ├── pom.xml
* └── README.md

## Prerequisites

1. **Java Development Kit (JDK) 22** or higher
2. **Apache Maven** 3.6.0 or higher
3. **IntelliJ IDEA** (Community or Ultimate Edition)
4. **Allure Commandline** (for generating Allure reports)

## Importing and Running the Project in IntelliJ IDEA

### Import the Project

1. Open **IntelliJ IDEA**.
2. Go to `File` -> `Open...`.
3. Select the root directory of your project where the `pom.xml` file is located.
4. IntelliJ IDEA will automatically detect the Maven project and prompt you to import it. Click `Import` or `Open as Project`.
5. IntelliJ IDEA will import the project and download all necessary dependencies.

### Running the Tests

1. In the `Project` view, navigate to `src/test/java/stepDef/PetStoreStepDef.java`.
2. Right-click on `PetStoreStepDef.java` and select `Run 'PetStoreStepDef'` to execute the Cucumber tests.
3. Alternatively, you can run the tests through Maven by going to `View` -> `Tool Windows` -> `Maven` and running the `clean test` goal from the Maven tool window.

## Generating the Allure Report

### Generate the Allure Report

1. Open the Terminal window in IntelliJ IDEA (`View` -> `Tool Windows` -> `Terminal`).
2. Run the following Maven command to generate the Allure report:
   ```sh
   mvn allure:report
