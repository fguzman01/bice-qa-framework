@web
Feature: Cart SauceDemo

    Background: 
        Given el usuario navega al login
        When ingresa usuario "standard_user" y password "secret_sauce"

    @ignore
    Scenario: Eliminar producto del carrito
        When busca el producto "Sauce Labs Bolt T-Shirt" y lo agrega al carrito
        And el usuario va al carrito
        Then el producto "Sauce Labs Bolt T-Shirt" debe estar en el carrito
        When el usuario elimina el producto "Sauce Labs Bolt T-Shirt" del carrito
        Then el producto "Sauce Labs Bolt T-Shirt" no debe estar en el carrito

    @ignore
    Scenario: Validar formulario checkout
        When busca el producto "Sauce Labs Bolt T-Shirt" y lo agrega al carrito
        And el usuario va al carrito
        And el usuario hace click en checkout
        Then el formulario de checkout debe tener los tres campos

    Scenario: Completar flujo de checkout exitosamente
        When busca el producto "Sauce Labs Bolt T-Shirt" y lo agrega al carrito
        And el usuario va al carrito
        And el usuario hace click en checkout
        Then el formulario de checkout debe tener los tres campos
        And completa el formulario de checkout con "Felipe" "Guzman" "7500000"
        And hacer click en continue
        Then el producto "Sauce Labs Bolt T-Shirt" debe aparecer en el resumen 
        When hace click en finish
        Then debe ver el mensaje de orden completada
        When hace click en volver al inicio
        Then debe ver la pagina de productos

