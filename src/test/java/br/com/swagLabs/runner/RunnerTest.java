package br.com.swagLabs.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //Para executar todas as features
        features = "src/test/java/br/com/swagLabs/features",

        glue = "br.com.swagLabs.steps",
        tags = "@SwagLabs_Compras",

        plugin = {"pretty", "html:evidencias/relatorio_html/evidence.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class RunnerTest {
}
