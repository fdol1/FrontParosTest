package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.BuscarDocumentoDeCompraException;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiMenuGestorParo.BTN_TABLERO_PAROS;
import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.SPN_SPINNER;

public class SeleccionaElTablero implements Task {

    public SeleccionaElTablero() {
    }

    public static SeleccionaElTablero deParos(){
        return Tasks.instrumented(SeleccionaElTablero.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_TABLERO_PAROS, WebElementStateMatchers.isEnabled()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_TABLERO_PAROS),
                    FalsaEspera.enPantalla(2000),
                    EsperarSpinner.duranteTransicion(SPN_SPINNER)
            );
        }catch (RuntimeException ex){
            throw new BuscarDocumentoDeCompraException(BuscarDocumentoDeCompraException.Error(), ex);
        }
    }
}