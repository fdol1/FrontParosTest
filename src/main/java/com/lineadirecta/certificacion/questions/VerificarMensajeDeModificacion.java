package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiSolicitudDeParos.MENSAJE_DE_IFORMACION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeDeModificacion implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeDeModificacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeDeModificacion delParoEditado(String mensaje){
        return new VerificarMensajeDeModificacion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(MENSAJE_DE_IFORMACION.of(mensaje),isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(MENSAJE_DE_IFORMACION.of(mensaje)).viewedBy(actor).asString());
    }
}