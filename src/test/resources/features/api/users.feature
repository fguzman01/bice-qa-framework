@api
Feature: Posts API - JSONPlaceholder

Scenario: Get post by id
  Given url apiBaseUrl + '/posts/1'
  When method Get
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

Scenario: Update a post
    Given url apiBaseUrl + '/posts/1'
    And request { id: 1, title: 'Updated title', body: 'Updated body', userId: 1 }
    When method PUT
    Then status 200
    * print 'Post actualizado:', response
    And match response.title == 'Updated title'

