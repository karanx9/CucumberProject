  Feature: Purchasescuirity device test

  Scenario: Purchase Security Device
    Given I am on Consumer Electronics
    When I click on Security and Gadgets
    And I click on Security Devices
    And I sort the products by cheapest first
    And  Applying filters
    And I enter the pincode ,and click check
    Then I should be able addtocart,proceed checkout and backhome
   


