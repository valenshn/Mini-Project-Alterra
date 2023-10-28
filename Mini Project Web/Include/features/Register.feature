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
Feature: Register

  @Register_Success
  Scenario Outline: Register success
    Given I am on the register page
    When I input <Nama_Lengkap> and <Email> and <Password>
    And I Click register button
    Then I am on the login page

    Examples: 
      | Nama_Lengkap  | Email 						 | Password  |
      | Valen Siahaan | siahaan235@gmail.com | shn123 	 |
      
  
  @Register_Failed_With_Fullname_Not_Inputted
  Scenario Outline: Register failed with fullname not inpputted
    Given I am on the register page
    When I enter <Email> and <Password> and let my nama lengkap empty
    And I Click register button
    Then I should verify error message that fullname is required

    Examples: 
       | Email 						  | Password  |
       | siahaan2@gmail.com | shn123 	  |
       
       
  @Register_Failed_With_Email_Not_Inputted
  Scenario Outline: Register failed with email not inpputted
    Given I am on the register page
    When I enter <Nama_Lengkap> and <Password> and my email empty
    And I Click register button
    Then I should receive error message that email is required

    Examples: 
      | Nama_Lengkap  | Password  |
      | Valen Siahaan | shn123 	  |   
  
  @Register_Failed_With_Password_Not_Inputted
  Scenario Outline: Register failed with password not inpputted
    Given I am on the register page
    When I enter <Nama_Lengkap> and <Email> and the password is empty
    And I Click register button
    Then I should receive error message that password is required

    Examples: 
      | Nama_Lengkap  | Email 						 | 
      | Valen Siahaan | siahaan2@gmail.com | 
      