package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.DataPickingModel;
import com.lineadirecta.certificacion.questions.VerificarListaPicking;
import com.lineadirecta.certificacion.tasks.RechazarParoSolicitado;
import com.lineadirecta.certificacion.tasks.SeleccionaElTablero;
import com.lineadirecta.certificacion.tasks.SeleccionarOrdenDeFabricacion;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionGestionDeParo {

    @Before
    public static void asignarElEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Que el confeccionista ingresa al tablero de paros$")
    public void queElConfeccionistaIngresaAlTableroDeParos() {
        theActorInTheSpotlight().attemptsTo(SeleccionaElTablero.deParos());
    }

    @When("^Selecciona la orden de fabricacion$")
    public void seleccionaLaOrdenDeFabricacion(List<DataPickingModel> dataPickingModels) {
        theActorInTheSpotlight().attemptsTo(SeleccionarOrdenDeFabricacion.enElListadoPicking(dataPickingModels.get(0)));
    }

    @When("^El gestor del paro ingresa el motivo de rechazo \"([^\"]*)\"$")
    public void elGestorDelParoIngresaElMotivoDeRechazo(String motivoRechazo) {
        theActorInTheSpotlight().attemptsTo(RechazarParoSolicitado.porConfeccionista(motivoRechazo));
    }

    @Then("^podra comprar el listado de picking$")
    public void podraComprarElListadoDePicking(List<DataPickingModel> dataPickingModels) {
        theActorInTheSpotlight().should(seeThat(VerificarListaPicking.delParoRegistrado(dataPickingModels.get(0))));
    }
}