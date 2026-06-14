@web
Feature: New Customer Form

Background:
   Given el usuario navega al login
   When ingresa usuario "mngr662929" y password "AqYgEzY"


Scenario: Validar formulario de nuevo cliente
  When el usuario hace clic en "New Customer"
  Then todos los campos del formulario deben estar presente


Scenario: Crear nuevo cliente
  When el usuario hace clic en "New Customer"
  When el usuario completa el formulario de nuevo cliente
  Then todos los campos deben estar completos
  