@EjecutarTodo
Feature: Realiar una moficiacion del cobro
  del paro en gestion

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario  | clave    |
      | 32143181 | 32143181 |

  @AgregarCobro
  Scenario: Intento de modificacion de cobro a si, Caso exitoso
    Given Que el confeccionista ingresa al tablero de paros
    When Cambia el estado del cobro a un: SI
    Then podra visualizar el mensaje exitoso:Se ha enviado la petición correctamente

  @QuitarCobro
  Scenario: Intento de modificacion de cobro no, Caso exitoso
    Given Que el confeccionista ingresa al tablero de paros
    When Cambia el estado del cobro a un: NO
    Then podra visualizar el mensaje exitoso:Se ha enviado la petición correctamente