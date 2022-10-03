package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.ModificarCobroException;
import com.lineadirecta.certificacion.interactions.ComandoJavaScript;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import com.lineadirecta.certificacion.interactions.SeleccionarCobro;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ModificarCobro implements Task {

    private final String opcionDeCobro;

    public ModificarCobro(String opcionDeCobro) {
        this.opcionDeCobro = opcionDeCobro;
    }

    public static ModificarCobro delParoEnGestion(String opcionDeCobro) {
        return Tasks.instrumented(ModificarCobro.class, opcionDeCobro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    EsperarSpinner.duranteTransicion(SPN_SPINNER),
                    WaitUntil.the(SCL_COBRO, isVisible()).forNoMoreThan(8).seconds(),
                    Click.on(SCL_COBRO),
                    FalsaEspera.enPantalla(1000),
                    SeleccionarCobro.paraParo(opcionDeCobro),
                    ComandoJavaScript.paraClic(BTN_GUARDAR_CAMBIO),
                    EsperarSpinner.duranteTransicion(SPN_SPINNER)
            );
        } catch (RuntimeException ex) {
            throw new ModificarCobroException(ModificarCobroException.Error(), ex);
        }
    }
}