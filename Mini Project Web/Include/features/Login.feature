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
@tag
Feature: Login
  

  @valid
  Scenario Outline: Login with valid credential
    Given I am on the login page
    When I enter my <email> and <password>
    And I click login button
    Then I should succesfully log in to my account
    

    Examples: 
      | email  															| password 				| 
      | valentina.siahaan@kawanlamacorp.com | siahaan 	  		| 
      
   @invalidCredentials
  Scenario Outline: Login with invalid credential
    Given I am on the login page
    When I enter an invalid <email> and <password>
    And I click login button
    Then I should not be able to login succesfully
    

    Examples: 
      | email  															| password 				| 
      | valentina.sian 											| siahaan 	  		| 
      
  @invalidWithEmailNotEnterd
  Scenario Outline: Login with email not entered
    Given I am on the login page
    When I enter <password> and let my email empty
    And I click login button
    Then I should receive error message that email is required
    

    Examples: 
   | password 			| 
   | siahaan 	  		| 
     
  @invalidWithPasswordNotEnterd
  Scenario Outline: Login with password not entered
    Given I am on the login page
    When I enter <email> and let my password empty
    And I click login button
    Then I should receive error message that password is required
    

    Examples: 
   | email 														| 
   | valenmargaretha@gmail.com 	  		| 
     