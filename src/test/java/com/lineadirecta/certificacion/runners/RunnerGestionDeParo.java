package com.lineadirecta.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/GestionDeParo.feature",
        tags = {"@EjecutarTodo"},
        glue ="com.lineadirecta.certificacion.stepsdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class RunnerGestionDeParo {
}