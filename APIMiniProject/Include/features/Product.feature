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

Feature: Product

Scenario: Get all product
    Given The API is available
    When I send request to endpoint get all products
    Then the response should be 200

Scenario: Create a new product
    Given The API is available
    When I send request to endpoint create a new product
    And the response should be 200
    Then the response should contain name, description, price and categories
    
   
 Scenario: Create a new product failed with price not inputted
    Given The API is available
    When I send request to endpoint create a new product  with price not inputted
    Then the response should be 400
    
   Scenario: Get product by id 
    Given The API is available
    When I send request to endpoint get product by ID
    And the response should be 200
   
 
    
  Scenario: Get product by id with ID not found
    Given The API is available
    When I send request to endpoint get product by ID Product with ID not found
    And the response should be 404
    Then the response should contain error record not found
    
  Scenario: Delete a product
    Given The API is available
    When I send request to endpoint delete a product
    And the response should be 200
    Then the response should data null
