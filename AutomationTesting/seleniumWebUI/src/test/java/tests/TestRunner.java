package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDef"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "pretty", "html:target/cucumber-reports.html"},
        tags = "@smoke"
)
public class TestRunner {
}
