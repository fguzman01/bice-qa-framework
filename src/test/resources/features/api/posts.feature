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

    
    Scenario: Post user id 1
        * print 'Post user 1'
        Given path ''
        And param userId = 1
        When method GET
        Then status 200
        * print 'Status:', responseStatus
        And match each response contains { userId: 1}

    
    Scenario: Delete
        * print 'Delete'
        Given path '/1'
        When method DELETE
        Then status 200
        * print 'Status:', responseStatus
        And match response == {}
        * print 'Response : ', response

    
    Scenario: Actualizar post
        * print 'actualizar post'
        Given path '/1'
        And request {title : 'Test BICE2', body: 'Contenido de prueba', userId: 1}
        When method PUT
        Then status 200
        And match response contains {title: 'Test BICE2', body: 'Contenido de prueba', userId: 1, id: 1}
        * print 'Response : ', response


    
    Scenario: Crear post y verificar que existe
        Given path ''
        And request { title: 'Consalud Test', body: 'Contenido', userId: 1 }
        When method POST
        Then status 201
        * def nuevoId = 1
        * print 'Id : ', response.id
        # ahora usa nuevoId para hacer el GET
        Given path '/' + nuevoId
        When method GET
        Then status 200
        And match response.id == nuevoId
    
    Scenario: Get filtrado 2
        Given path ''
        And param userId = 2
        When method GET
        Then status 200
        #para validar objetos
        #And match response == '#notempty'
        And assert response.length > 0
        And match response == '#[10]'
        And match each response contains { userId: 2}
    
    
    Scenario: Valida post 5
        Given path '/5'
        When method GET
        Then status 200
        And  match response.id == '#number'
        And match response.userId == '#number'
        And match response.title == '#string'

    Scenario: Scenario post validando datos
        Given path '/'
        And  request {title: 'Test desafio1', body: 'test', userId: 1}
        When method POST
        Then status 201
        * print 'Status es :', responseStatus
        And match response.id == '#number'
        * print 'Response id: ', response.id
        * print 'Body request',  response 

    
    @test
    Scenario: Get posts page 1
        Given path ''
        And param _page = 1
        When method GET
        Then status 200
        And assert response.length > 0


    



    
       





       



