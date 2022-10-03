@EjecutarTodo
Feature: Realiar una verificacion del picking
  Registrado para un paro

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario  | clave    |
      | 32143181 | 32143181 |

  @VerificarPicking
  Scenario Outline: Intento de verificacion de picking, Caso exitoso
    Given Que el confeccionista ingresa al tablero de paros
    When Selecciona la orden de fabricacion
      | ordFabricacion   |
      | <ordFabricacion> |
    Then podra comprar el listado de picking
      | componente   | categoria   | textoComponente   | lote   | unidadMedida   | cantidadOt   |
      | <componente> | <categoria> | <textoComponente> | <lote> | <unidadMedida> | <cantidadOt> |
    Examples:
      | ordFabricacion | componente | categoria | textoComponente          | lote | unidadMedida | cantidadOt |
      | 2423738        | 204344     | LD A      | BOLSA LD MEDIANA 180*200 | LDA  | UN           | 676        |

  @IngresarMotivoRechazo
  Scenario Outline: Intento para ingresar el motivo de rechazo del paro, caso exitoso
    Given Que el confeccionista ingresa al tablero de paros
    When El gestor del paro ingresa el motivo de rechazo "<motivoRechazo>"
    Then podra visualizar el mensaje exitoso:Se ha enviado la petición correctamente
    Examples:
      | motivoRechazo                                                       |
      | Se rechaza el paro porque esta mal diligenciado y falta informacion |