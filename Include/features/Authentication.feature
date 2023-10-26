#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Authectication

  
  Scenario: Register
    Given The API is available
    When I send POST request to endpoint register
    And the response should be 200
    Then the response should verify that email is same with the request
    
  Scenario: Register with the same email
    Given The API is available
    When I send POST request to endpoint register with same email
    And the response should be 400
    Then the response should show error message duplicate key
    
    Scenario: Login
    Given The API is available
    When I send POST request to endpoint Login
    And the response should be 200
   
     Scenario: Login with invalid email
    Given The API is available
    When I send POST request to endpoint Login with invalid email
    And the response should be 400
    Then the response should contain error record not found
    
    Scenario: Login with invalid password
    Given The API is available
    When I send POST request to endpoint Login with invalid password
    And the response should be 400
    Then the response should show error message email or password invalid
    
    #Scenario: get user information
    #Given The API is available
    #When I send GET request to endpoint user information
    #And the response should be 200
    