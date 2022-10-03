package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.SeleccionarOrdenDeFabricacionException;
import com.lineadirecta.certificacion.interactions.ComandoJavaScript;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import com.lineadirecta.certificacion.models.DataPickingModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.lineadirecta.certificacion.userinterfaces.UiTableroGestorParos.BTN_ORDEN_FABRICACION;

public class SeleccionarOrdenDeFabricacion implements Task {

    private final DataPickingModel dataPickingModel;

    public SeleccionarOrdenDeFabricacion(DataPickingModel dataPickingModel) {
        this.dataPickingModel = dataPickingModel;
    }

    public static SeleccionarOrdenDeFabricacion enElListadoPicking(DataPickingModel dataPickingModel) {
        return Tasks.instrumented(SeleccionarOrdenDeFabricacion.class, dataPickingModel);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    FalsaEspera.enPantalla(2000),
                    ComandoJavaScript.paraClic(BTN_ORDEN_FABRICACION)
            );
        }catch (RuntimeException ex){
            throw new SeleccionarOrdenDeFabricacionException(SeleccionarOrdenDeFabricacionException.Error(),ex);
        }
    }
}