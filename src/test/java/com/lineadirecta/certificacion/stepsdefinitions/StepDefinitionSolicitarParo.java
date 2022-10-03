package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.questions.VerificarMensajeDeModificacion;
import com.lineadirecta.certificacion.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionSolicitarParo {

    @Before
    public static void asignarElEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^El gestor del paro busca el \"([^\"]*)\"$")
    public void elGestorDelParoBuscaEl(String docCompra) {
        theActorInTheSpotlight().attemptsTo(HacerSolicitudDeParo.paraProduccionDetenida(docCompra));
    }

    @When("^Realiza la modificacion de la \"([^\"]*)\"$")
    public void realizaLaModificacionDeLa(String causa) {
        theActorInTheSpotlight().attemptsTo(ModificarCausal.delParo(causa));
    }

    @When("^Realiza la modificacion con \"([^\"]*)\" y \"([^\"]*)\"$")
    public void realizaLaModificacionConY(String cantidad, String nota) {
        theActorInTheSpotlight().attemptsTo(ModificarCantidadInsumo.delParoSeleccionado(cantidad,nota));
    }

    @When("^Realiza la modificacion del proceso (.*)$")
    public void realizaLaModificacionDelProceso(String procesoSolicitado) {
        theActorInTheSpotlight().attemptsTo(ModificarProcesoSolicitado.delParo(procesoSolicitado));
    }

    @When("^Cambia el estado del cobro a un: (.*)$")
    public void cambiaElEstadoDelCobroAUnSI(String opcionDePago) {
        theActorInTheSpotlight().attemptsTo(ModificarCobro.delParoEnGestion(opcionDePago));
    }

    @Then("^podra visualizar el mensaje exitoso:(.*)$")
    public void podraVisualizarElMensajeExitoso(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeModificacion.delParoEditado(mensaje)));
    }
}