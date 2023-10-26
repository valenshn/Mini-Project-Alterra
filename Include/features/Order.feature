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
Feature: Order

  
  Scenario: Create a new order
    Given The API is available
    When I send POST request to endpoint create a new order
    Then the response should be 200
  
  
  Scenario: Get all orders
    Given The API is available
    When I send GET request to endpoint get all orders
    Then the response should be 200
    
    
    Scenario: Get order by ID
    Given The API is available
    When I send GET request to endpoint get order by ID
    Then the response should be 200
