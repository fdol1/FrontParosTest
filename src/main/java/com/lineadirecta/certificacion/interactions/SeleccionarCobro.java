package com.lineadirecta.certificacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.SCL_COBRO_VALUE_NO;
import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.SCL_COBRO_VALUE_SI;

public class SeleccionarCobro implements Interaction {

    private final String decision;

    public SeleccionarCobro(String decision) {
        this.decision = decision;
    }

    public static SeleccionarCobro paraParo(String decision) {
        return Tasks.instrumented(SeleccionarCobro.class, decision);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if(decision.equals("SI")){
            actor.attemptsTo(
                    Click.on(SCL_COBRO_VALUE_SI)
            );
        }else {
            actor.attemptsTo(
                    Click.on(SCL_COBRO_VALUE_NO)
            );
        }
    }
}