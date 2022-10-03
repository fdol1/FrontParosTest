@EjecutarTodo
Feature: Realizar una solicitud de paro para el articulo en produccion
  y este a su vez sea atendido por el gestor de paros

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave    |
      | 900686800 | dgyaqrig |

  @ModificarCausal
  Scenario Outline: Intento de modificacion de causal, Caso exitoso
    Given El gestor del paro busca el "<docCompra>"
    When Realiza la modificacion de la "<causal>"
   # Then podra visualizar el mensaje exitoso:La petición ha sido enviada correctamente.
    Examples:
      | docCompra  | causal           |
      | 5100562926 | Error de medidas |


  @ModificarCantidad
  Scenario Outline: Intento de modificacion de cantidad, caso exitoso
    Given El gestor del paro busca el "<docCompra>"
    When Realiza la modificacion con "<cantidad>" y "<observacion>"
 #   Then podra visualizar el mensaje exitoso:La petición ha sido enviada correctamente.
    Examples:
      | docCompra  | cantidad | observacion                                              |
      | 5100562926 | 8        | Esto es una prueba realizada desde un robot automatizado |


  @ModificarProcesoSolicitado
  Scenario Outline: Intento de modificacion proceso solicitado, caso exitoso
    Given El gestor del paro busca el "<docCompra>"
    When Realiza la modificacion del proceso "<procesoSolicitado>"
  #  Then podra visualizar el mensaje exitoso:La petición ha sido enviada correctamente.
    Examples:
      | docCompra  | procesoSolicitado         |
      | 5100570826 | ESTAMPACIÓN PRENDAS/TELAS |