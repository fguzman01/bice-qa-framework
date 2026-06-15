@web
Feature: Products SauceDemo

    Background:
        Given el usuario navega al login
        When ingresa usuario "standard_user" y password "secret_sauce"

    Scenario: Listar todos los productos con su precio
        Then se deben listar todos los productos disponibles