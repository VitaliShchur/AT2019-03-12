package by.it.udalyou.сucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/java/by/it/udalyou/сucumber",
      //  glue = "src.test.java.by.it.udalyou.cucumber",
      // glue = "src/test/java/by/it/udalyou/cucumber/TaskA",
       // tags = "@all",
       // dryRun = true,
      // strict = true,

        snippets = SnippetType.CAMELCASE
)
public class BddAiaLineTest extends AbstractTestNGCucumberTests {
}
