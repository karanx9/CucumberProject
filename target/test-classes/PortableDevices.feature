  @tag 
  Feature: PortableDevicesPage :
  
  @tag1 @portable-devices
  Scenario: Compare Portable Devices
    Given navigate Consumer Electronics page
    When I click on Portable Devices
    And I select a branded item,price range
    And I select two items to compare and click comparebtn
    And I should be able to view the comparison results and close window

