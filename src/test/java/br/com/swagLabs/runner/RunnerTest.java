package br.com.swagLabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Para executar todas as features
        features = "src/test/java/br/com/swagLabs/features/swaglabs.feature",

        glue = "br.com.swagLabs.steps",
        tags = "@ct01",

        plugin = {"pretty", "html:evidencias/html/evidence-html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class RunnerTest {
}
