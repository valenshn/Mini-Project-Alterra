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

Feature: Product Categories

  
  Scenario: Create a category
    Given The API is available
    When I send POST request to endpoint create a category
    And the response should be 200
    Then the response should contain name and description
     
    
  Scenario: Get all categories
    Given The API is available
    When I send GET request to endpoint get all categories
    Then the response should be 200
 
   Scenario: get categories by ID
    Given The API is available
    When I send GET request to endpoint get categories by ID
    And the response should be 200
    Then the response should show categories based on ID
    
   Scenario: get categories by ID not found
    Given The API is available
    When I send GET request to endpoint get categories by ID with ID not found
    And the response should be 404
    Then the response should contain error record not found
   
    Scenario: Delete a category
    Given The API is available
    When I send DELETE request to endpoint delete a category
    And the response should be 200
    Then the response should data null
    