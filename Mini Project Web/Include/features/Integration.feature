Feature: Transaction

Scenario: I can choose a product and pay for it
    Given I am on the homepage
    When I add product to my cart
    And I can pay for it
    Then I can see the histori on transaction page
    
