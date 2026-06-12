@api
Feature: Users API - Reqres

  Background:
    * header x-api-key = 'free_user_3EY53Y6P0ViM05wYnAJMrsie8vh'

  Scenario: Get list of users successfully
    Given url 'https://reqres.in/api/users'
    And param page = 2
    When method GET
    Then status 200
    * print 'Status:', responseStatus
    * print 'Pagina:', response.page
    * print 'Total usuarios:', response.total
    And match response.page == 2
    And match response.data == '#[6]'
    And match each response.data contains { id: '#number', email: '#string' }