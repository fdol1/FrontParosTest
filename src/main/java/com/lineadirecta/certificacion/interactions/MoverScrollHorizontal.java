package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebElement;

public class MoverScrollHorizontal implements Interaction {

    private final String elemento;

    public MoverScrollHorizontal(String elemento) {
        this.elemento = elemento;
    }

    public static MoverScrollHorizontal alIdIndicadoPorEl(String elemento){
        return Tasks.instrumented(MoverScrollHorizontal.class,elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            WebElement scrollDerecha = GetDriver.as(actor).webDriver().findElement(new By.ByXPath(elemento));
            JavascriptExecutor jse = (JavascriptExecutor) GetDriver.as(actor).webDriver();
            jse.executeAsyncScript("arguments[0].scrollIntoView()", scrollDerecha);
        }catch (ScriptTimeoutException e){
            e.printStackTrace();
        }
    }
}