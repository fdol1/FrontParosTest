package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.ModificarCausalException;
import com.lineadirecta.certificacion.interactions.EnviarModificacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.*;

public class ModificarProcesoSolicitado implements Task {

    private final String procesoSolicitado;

    public ModificarProcesoSolicitado(String procesoSolicitado) {
        this.procesoSolicitado = procesoSolicitado;
    }

    public static ModificarProcesoSolicitado delParo(String procesoSolicitado){
        return Tasks.instrumented(ModificarProcesoSolicitado.class, procesoSolicitado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(SCL_PROCESO_SOLICITADO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(SCL_PROCESO_SOLICITADO),
                    WaitUntil.the(SCL_PROCESO_SOLICITADO_VALUE, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(SCL_PROCESO_SOLICITADO_VALUE),
                    //ComandoJavaScript.paraClic(SCL_PROCESO_SOLICITADO_VALUE),
                    WaitUntil.the(BTN_ENVIAR, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    EnviarModificacion.delParo()
            );
        }catch (RuntimeException ex){
            throw new ModificarCausalException(ModificarCausalException.Error(),ex);
        }
    }
}