package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.RechazoParoSolicitadoException;
import com.lineadirecta.certificacion.interactions.ComandoJavaScript;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RechazarParoSolicitado implements Task {

    private final String motivoRechazado;

    public RechazarParoSolicitado(String motivoRechazado) {
        this.motivoRechazado = motivoRechazado;
    }

    public static RechazarParoSolicitado porConfeccionista(String motivoRechazado){
        return Tasks.instrumented(RechazarParoSolicitado.class, motivoRechazado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    EsperarSpinner.duranteTransicion(SPN_SPINNER),
                    WaitUntil.the(SCL_COBRO, isVisible()).forNoMoreThan(8).seconds(),
                    Click.on(SCL_COBRO),
                    Enter.theValue(motivoRechazado).into(TXT_MOTIVO_PARO),
                    ComandoJavaScript.paraClic(BTN_GUARDAR_CAMBIO),
                    EsperarSpinner.duranteTransicion(SPN_SPINNER)
            );
        }catch (RuntimeException ex){
            throw new RechazoParoSolicitadoException(RechazoParoSolicitadoException.Error(), ex);
        }
    }
}