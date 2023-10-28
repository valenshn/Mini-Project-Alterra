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

Feature: Pagination of transaction

  Scenario: Next Page of transaction
    Given I am on the transaction page
    When I click next page button
    Then I am on the next page of transaction
    
  Scenario: Previous Page of transaction
    Given I am on the transaction page
    When  I click previous page button
    Then  I am on the previous page of transaction