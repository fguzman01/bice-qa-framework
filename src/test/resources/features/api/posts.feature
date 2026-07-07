@api
Feature: Posts API - JSONPlaceholder

    Background:
    * url apiBaseUrl + '/posts'


    Scenario: Post all data
        Given path ''
        When method GET
        Then status 200
        * print 'Status:', responseStatus
        And match response == '#[100]'

    Scenario: Post data [1]
        Given path '/1'
        When method GET
        Then status 200
        And match response.userId == '#number'
        * print 'UserId : ', response.userId
        And match response.body == '#string'
        * print 'Response body : ', response.body
        And match response.title == '#string'
        * print 'Response title : ', response.title

    Scenario: Envio data
        Given path ''
        And request { title: 'Test consalud', body: 'Contenido', userId: 1 }
        When method POST
        Then status 201
        And match response.title == 'Test consalud'
        And match response.userId == 1
        And match response.id == '#number'

    Scenario: Validar estructura de todos los posts
        Given path ''
        When method GET
        Then status 200
        And match each response contains {id: '#number', userId: '#number', title: '#string', body: '#string'}


       



