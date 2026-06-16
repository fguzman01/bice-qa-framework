@api
@todos
Feature: APi - todos

    Scenario: Validación de campos GET
        Given url apiBaseUrl + '/todos/1'
        When method GET
        Then status 200
        * print 'Status:', responseStatus
        * print 'Pagina:', response
        And match response.id == '#number'
        And match response.userId == '#number'
        And match response.title == 'delectus aut autem'
