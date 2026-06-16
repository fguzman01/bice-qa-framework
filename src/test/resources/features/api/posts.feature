@api
Feature: Posts y Comments API - JSONPlaceholder

    @getPost
    Scenario: Get post by id
        Given url apiBaseUrl + '/posts/1'
        When method GET
        Then status 200
        * print 'Post:', response
        And match response.id == 1
        And match response.userId == '#number'
        And match response.title == '#string'

    @createPost
    Scenario: Create a new post
        Given url apiBaseUrl + '/posts'
        And request { title: 'Test BICE', body: 'Contenido de prueba', userId: 1 }
        When method POST
        Then status 201
        * print 'Post creado:', response
        And match response.title == 'Test BICE'
        And match response.id == '#present'

    @updatePost
    Scenario: Update a post
        Given url apiBaseUrl + '/posts/1'
        And request { id: 1, title: 'Updated title', body: 'Updated body', userId: 1 }
        When method PUT
        Then status 200
        * print 'Post actualizado:', response
        And match response.title == 'Updated title'

    @getComments
    Scenario: Obtener comentarios de un post especifico
        Given url apiBaseUrl + '/comments'
        And param postId = 1
        When method GET
        Then status 200
        * print 'Total comentarios:', response.length
        And match response[0].postId == 1
        And match each response[*].email == '#regex .+@.+\\..+'

    @deletePost
    Scenario: Eliminar post
        Given url apiBaseUrl + '/posts/1'
        When method DELETE
        * print 'Status code ' + responseStatus
        Then status 200
        * print 'Respuesta' + response
        * print 'Post eliminado'

    @schemaValidation
    Scenario: Validar schema de post
        Given url apiBaseUrl + '/posts/1'
        When method GET
        Then status 200
        * print 'Response', response
        And match response ==
        """
        {
            userId: '#number',
            id: '#number',
            title: '#string',
            body: '#string'
        }
        """
    @chainedCalls
    Scenario: Obtener post y luego sus comentarios
        # Paso 1 : obtener el post
        Given url apiBaseUrl + '/posts/1'
        When method GET
        Then status 200
        * def postId = response.id
        * print 'Post obtenido con id', postId

        # Paso 1 : obtener el post
        Given url apiBaseUrl + '/comments'
        And param postId = postId
        When method GET
        Then status 200
         * print 'Comentarios encontrados:', response.length
        And match each response[*].postId == postId

    


   