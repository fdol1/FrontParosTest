package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.ComandoJavaScriptException;
import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebElement;

public class ComandoJavaScript implements Interaction {

    private final String elemento;

    public ComandoJavaScript(String elemento) {
        this.elemento = elemento;
    }

    public static ComandoJavaScript paraClic(String elemento) {
        return Tasks.instrumented(ComandoJavaScript.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            try {
                WebElement BTN_GUARDAR = GetDriver.as(actor).webDriver().findElement(new By.ByXPath(elemento));
                JavascriptExecutor executor = (JavascriptExecutor) GetDriver.as(actor).webDriver();
                executor.executeScript("arguments[0].click();", BTN_GUARDAR);
            }catch (ScriptTimeoutException e){
                e.printStackTrace();
            }
        }catch (RuntimeException ex){
            throw new ComandoJavaScriptException(ComandoJavaScriptException.Error(),ex);
        }
    }
}