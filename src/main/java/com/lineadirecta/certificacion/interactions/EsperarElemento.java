package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.EsperarElementoException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

public class EsperarElemento implements Interaction {

    private final Target elementoAEsperar;

    public EsperarElemento(Target elementoAEsperar) {
        this.elementoAEsperar = elementoAEsperar;
    }

    public static EsperarElemento duranteTransicion(Target elementoAEsperar){
        return Tasks.instrumented(EsperarElemento.class, elementoAEsperar);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            do {
                Logger.getAnonymousLogger().info("Se termina la espera del elemento");
                break;
            }while (!elementoAEsperar.resolveFor(actor).isClickable());
        }catch (RuntimeException ex){
            throw new EsperarElementoException(EsperarElementoException.Error(),ex);
        }
    }
}