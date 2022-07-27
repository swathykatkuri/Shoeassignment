@tag
Feature: Shoe store

  Scenario: Verify the brand search
    Given Go to shoe store
    When Search "Valentino" in the brand
    Then Validate search result
	
  Scenario Outline: Verify the email notification message
    Given Go to shoe store
    Then Enter the email address as "<email_address>" and validate message

    Examples: 
      | email_address  |
      | |
      | test@gmail.com |
      | test@sdfasdf   |

      Scenario Outline: Validating promo code
      Given Go to shoe store
      Then Enter the promo code as "<promocode>" and validate message
      Examples: 
      | promocode  |
      | aadkfa-asd|
     