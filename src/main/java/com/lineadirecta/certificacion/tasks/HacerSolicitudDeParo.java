package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.HacerSolicitudDeParoException;
import com.lineadirecta.certificacion.interactions.EsperarElemento;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiMenuConfeccionista.BTN_SOLICITAR_PARO;
import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.CKBX_ITEM;
import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.TXT_BUSCAR_ORDEN;
import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.SPN_SPINNER;

public class HacerSolicitudDeParo implements Task {

    private final String docCompra;

    public HacerSolicitudDeParo(String docCompra) {
        this.docCompra = docCompra;
    }

    public static HacerSolicitudDeParo paraProduccionDetenida(String docCompra) {
        return Tasks.instrumented(HacerSolicitudDeParo.class, docCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    EsperarElemento.duranteTransicion(BTN_SOLICITAR_PARO),
                    Click.on(BTN_SOLICITAR_PARO),
                    FalsaEspera.enPantalla(2000),
                    EsperarSpinner.duranteTransicion(SPN_SPINNER),
                    Enter.theValue(docCompra).into(TXT_BUSCAR_ORDEN),
                    WaitUntil.the(CKBX_ITEM, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(CKBX_ITEM)
            );
        }catch (RuntimeException ex){
            throw new HacerSolicitudDeParoException(HacerSolicitudDeParoException.Error(), ex);
        }
    }
}