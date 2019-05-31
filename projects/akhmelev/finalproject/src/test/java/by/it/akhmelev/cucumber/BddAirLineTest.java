package by.it.akhmelev.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/by/it/akhmelev/cucumber",
        glue = "by.it.akhmelev.cucumber",
        snippets = SnippetType.CAMELCASE
)
public class BddAirLineTest extends AbstractTestNGCucumberTests {
}
