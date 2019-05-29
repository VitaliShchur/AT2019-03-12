package by.it.tsyhanova.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/by/it/tsyhanova/cucumber",
        glue = "by.it.tsyhanova.cucumber",
        snippets = SnippetType.CAMELCASE
)
public class BddAirLineTest extends AbstractTestNGCucumberTests {
}
