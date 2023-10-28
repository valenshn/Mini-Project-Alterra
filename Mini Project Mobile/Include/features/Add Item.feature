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

Feature: Add item
  

  Scenario: User success add new item
    Given I already open the application
    When  I click add button, i direct to add new item page
    And I input the name and quantity
    And I click add new item button
    Then I success to add the item
      

  Scenario: User add new item failed with "name " not inputted
   Given I click add button, i direct to add new item page
    When I enter the quantity and let the name empty
    And I click add new item button
    Then I can view an error message in email field

  
  Scenario: User add new item failed with "quantity " not inputted
   Given  I click add button, i direct to add new item page
    When I enter the name and let the quantity empty
    And I click add new item button
    Then I can view an error message in quantity field
    
   Scenario: User add new item failed with "name" and "quantity " not inputted
   Given  I click add button, i direct to add new item page
    When I let name and the quantity empty
    And I click add new item button
    Then I can view an error message in quantity field and name field


  Scenario: User add new item failed with "quantity " is negative
    Given I click add button, i direct to add new item page
    When I enter the name and negative quantity
    And I click add new item button
    Then I can view an error message in quantity field
