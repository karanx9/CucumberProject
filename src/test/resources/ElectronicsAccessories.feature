 @tag
 Feature: Electronicspage 
  
  
  @tag1
  Scenario: Browse and purchase from Electronics Accessories
    Given Open the url and navigate to the Consumer Electronics page
    When I click on Electronics Accessories
    And I apply the following filters:
      | Cash on Delivery    |
      | Exclude out of stock|
      | Free shipping       |
    And I select Casio brand
    And I select a price range
    And I click on the second product
    Then I should be able to add the product to cart
    And I should be able to proceed to checkout
    And I should be able to navigate back to homepage

  
