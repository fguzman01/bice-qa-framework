@ignore
@web
Feature: Login Sauce demo

  Background:
    Given el usuario navega al login

  @ignore
  Scenario: Login exitoso con credenciales válidas
    When ingresa usuario "<usuario>" y password "<password>"
    Then debe ver la pagina de productos

    Examples: 
      | usuario       | password     |
      | standard_user | secret_sauce |

  Scenario: Login fallido con passwor vacia
    When ingresa usuario "<usuario>" y password "<password>"
    Then debe entregar error por falta de datos

    Examples: 
      | usuario       | password |
      | standard_user |          |


  Scenario: Login fallido con passwor incorrecta
    When ingresa usuario "<usuario>" y password "<password>"
    Then debe entregar error por password incorrecto

    Examples: 
      | usuario       | password        |
      | standard_user | wrong_password  |


   Scenario: Login fallido por  usuario bloqueado
    When ingresa usuario "<usuario>" y password "<password>"
    Then debe entregar error por usuario bloqueado

    Examples: 
      | usuario         | password      |
      | locked_out_user | secret_sauce  |


   Scenario: Login exitoso con usuario desde DataProvider
     When el usuario valido desde DataProvider intenta ingresar
     Then debe ver la pagina de productos