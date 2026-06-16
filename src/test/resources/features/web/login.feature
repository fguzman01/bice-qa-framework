@web
Feature: Login Practice Test Automation

  Background:
    Given el usuario navega al login

  Scenario: Login exitoso con credenciales válidas
    When ingresa usuario "student" y password "Password123"
    Then debe ver la pagina de login succes

  Scenario Outline: Login con example
    When ingresa usuario "<username>" y password "<password>"
    Then debe ver la pagina de login succes

    Examples:
      | username | password    |
      | student  | Password123 |

  Scenario: Login exitoso con credenciales validas Dataprovider
    When el usuario valido desde DataProvider intenta ingresar
    Then debe ver la pagina de login succes

  Scenario Outline: Login con credenciales invalidas
    When ingresa usuario "<username>" y password "<password>"
    Then debe entregar error invalid

    Examples:
      | username       | password    |
      | incorrectUser  | Password123 |
