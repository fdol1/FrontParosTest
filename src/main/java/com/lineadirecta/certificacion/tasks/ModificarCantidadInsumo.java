package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.ModificarCantidadInsumoException;
import com.lineadirecta.certificacion.interactions.EnviarModificacion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.*;

public class ModificarCantidadInsumo implements Task {
    private final String cantidad;
    private final String observacion;

    public ModificarCantidadInsumo(String cantidad, String observacion) {
        this.cantidad = cantidad;
        this.observacion = observacion;
    }

    public static ModificarCantidadInsumo delParoSeleccionado(String cantidad,String observacion) {
        return Tasks.instrumented(ModificarCantidadInsumo.class, cantidad,observacion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(TXT_CANTIDAD_INSUMOS, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Enter.theValue(cantidad).into(TXT_CANTIDAD_INSUMOS),
                    Click.on(BTN_OBSERVACION),
                    WaitUntil.the(TXT_OBSERVACION, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Enter.theValue(observacion).into(TXT_OBSERVACION),
                    Click.on(BTN_GUARDAR_OBSERVACION),
                    EnviarModificacion.delParo()
            );
        }catch (RuntimeException ex){
            throw new ModificarCantidadInsumoException(ModificarCantidadInsumoException.Error(),ex);
        }
    }
}