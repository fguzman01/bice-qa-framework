@api
Feature: Users API - Reqres

  Scenario: Get list of users successfully
    Given url apiBaseUrl + '/users'
    And param page = 2
    When method GET
    Then status 200
    * print 'Status:', responseStatus
    * print 'Pagina:', response.page
    * print 'Total usuarios:', response.total
    And match response.page == 2
    And match response.data == '#[6]'
    And match each response.data contains { id: '#number', email: '#string' }


  Scenario: Crear un nuevo usuario
    Given url apiBaseUrl + '/users'
    And request {name : 'Felipe', job : 'QA'}
    When method POST
    Then status 201
    * print 'Status:', responseStatus
    * print 'Usuario creado: ', response
    And match response.name == 'Felipe'
    And match response.job == 'QA'
    And match response.id == '#present'
    And match response.createdAt == '#present'


  Scenario: Crear usuario sin job - fallo
    Given url apiBaseUrl + '/register'
    And request { email: 'sydney@fife'}
    When method POST
    Then status 400
    * print 'Error esperado', response
    And match response.error == 'Missing password'