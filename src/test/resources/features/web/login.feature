@web
Feature: Login ParaBank

  Background:
    Given el usuario navega al login
    

  Scenario: Login exitoso con credenciales válidas
    When usuario click en mensaje entendido
    And  usuario click en ya tengo cuenta
    When ingresa usuario "test@test.cl" y password "123456"
    And click en submit
    Then debe entregar error de credenciales 

  