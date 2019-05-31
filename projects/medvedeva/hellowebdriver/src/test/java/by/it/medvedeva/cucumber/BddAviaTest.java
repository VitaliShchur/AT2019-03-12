package by.it.medvedeva.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/by/it/medvedeva/cucumber",
                    glue = "by.it.medvedeva.cucumber",
                    snippets = SnippetType.CAMELCASE
)

public class BddAviaTest extends AbstractTestNGCucumberTests {
}
