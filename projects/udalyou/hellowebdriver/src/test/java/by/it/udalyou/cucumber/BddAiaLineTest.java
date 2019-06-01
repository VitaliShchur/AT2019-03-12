package by.it.udalyou.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/java/by/it/udalyou/cucumber",
        glue = "by.it.udalyou.cucumber",
      // glue = "src/test/java/by/it/udalyou/cucumber/TaskA",
       // tags = "@all",
       // dryRun = true,
      // strict = true,

        snippets = SnippetType.CAMELCASE
)
public class BddAiaLineTest extends AbstractTestNGCucumberTests {
}
