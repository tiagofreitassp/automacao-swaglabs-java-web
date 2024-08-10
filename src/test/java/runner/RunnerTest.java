package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Para executar todas as features
        features = "src/test/java/features",

        glue = "steps",
        tags = "@Regressivo",

        plugin = {"pretty", "html:target/evidencias/relatorio_html/evidence.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class RunnerTest {
}
