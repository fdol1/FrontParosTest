package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.EnviarModificacionException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.*;

public class EnviarModificacion implements Interaction {

    public static EnviarModificacion delParo(){
        return Tasks.instrumented(EnviarModificacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ENVIAR, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_ENVIAR),
                    ComandoJavaScript.paraClic(BTN_GUARDAR_MODIFICACION_PARO),
                    WaitUntil.the(BTN_CONTINUAR, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_CONTINUAR)
            );
        }catch (RuntimeException ex){
            throw new EnviarModificacionException(EnviarModificacionException.Error(),ex);
        }
    }
}