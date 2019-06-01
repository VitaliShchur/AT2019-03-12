package by.it.simanovich.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import static cucumber.api.SnippetType.CAMELCASE;

@CucumberOptions(
        features = "src/test/java/by/it/simanovich/cucumber",
        glue = "by.it.simanovich.cucumber",
        snippets = CAMELCASE
)
public class BddAviaTest extends AbstractTestNGCucumberTests {
}
