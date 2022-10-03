package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.ModificarCausalException;
import com.lineadirecta.certificacion.interactions.EnviarModificacion;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.SCL_CAUSA_PARO;
import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.SCL_CAUSA_PARO_VALUE;
import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.SPN_SPINNER;

public class ModificarCausal implements Task {

    private final String causal;

    public ModificarCausal(String causal) {
        this.causal = causal;
    }

    public static ModificarCausal delParo(String causal){
        return Tasks.instrumented(ModificarCausal.class, causal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(SCL_CAUSA_PARO, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(SCL_CAUSA_PARO),
                    WaitUntil.the(SCL_CAUSA_PARO_VALUE.of(causal), WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(SCL_CAUSA_PARO_VALUE.of(causal)),
                    EnviarModificacion.delParo(),
                    EsperarSpinner.duranteTransicion(SPN_SPINNER)
            );
        }catch (RuntimeException ex){
            throw new ModificarCausalException(ModificarCausalException.Error(),ex);
        }
    }
}