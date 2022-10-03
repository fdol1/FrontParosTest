package com.lineadirecta.certificacion.questions;

import com.lineadirecta.certificacion.models.DataPickingModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiListadoPicking.LBL_COMPONENTE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarListaPicking implements Question<Boolean> {

    private final DataPickingModel dataPickingModel;

    public VerificarListaPicking(DataPickingModel dataPickingModel) {
        this.dataPickingModel = dataPickingModel;
    }

    public static VerificarListaPicking delParoRegistrado(DataPickingModel dataPickingModel){
        return new VerificarListaPicking(dataPickingModel);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_COMPONENTE.of(dataPickingModel.getComponente()),isVisible()).forNoMoreThan(10).seconds()

        );
        return dataPickingModel.getComponente().equals(Text.of(LBL_COMPONENTE.of(dataPickingModel.getComponente())).viewedBy(actor).asString());
    }
}