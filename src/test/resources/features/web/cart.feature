@web
Feature: Cart SauceDemo

    Background: 
        Given el usuario navega al login
        When ingresa usuario "standard_user" y password "secret_sauce"

    Scenario: Eliminar producto del carrito
        When busca el producto "Sauce Labs Bolt T-Shirt" y lo agrega al carrito
        And el usuario va al carrito
        Then el producto "Sauce Labs Bolt T-Shirt" debe estar en el carrito
        When el usuario elimina el producto "Sauce Labs Bolt T-Shirt" del carrito
        Then el producto "Sauce Labs Bolt T-Shirt" no debe estar en el carrito
