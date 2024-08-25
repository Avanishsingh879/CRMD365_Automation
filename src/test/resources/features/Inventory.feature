Feature: Validating Inventory page
   

@Regression   @Inventory_1  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application open UrL
    When user Enter Username and Password by click on login Button
    Then login sucessfully
    And user is in VtigerCRM Home page
    And User has click on Inventory tab
    
@Regression   @Inventory2  @TC_002
 Scenario Outline: verify the Vtiger Login Page
    Given I navigate to application open UrL
    When user Enter Username and Password by click on login Button
    Then login sucessfully
    And user is in VtigerCRM Home page
    And User has click on Inventory tab
    And User verify the Creating Products"<ProductName>" in Inventory by click on Save button
    
    Examples:
  
    |ProductName|
    |TestProduct|
    
 @Regression @Inventory3  @TC_003
 Scenario Outline: verify the Vtiger Login Page
    Given I navigate to application open UrL
    When user Enter Username and Password by click on login Button
    Then login sucessfully
    And user is in VtigerCRM Home page
    And User has verify on Inventory tab
    And User has click on Invoice tab
    And User verify the Creating New Invoice "<Subject>","<AccountName>" in Inventory by click on Save button
    
    Examples:
  
    |Subject|AccountName|
    |TestInvoice|Genpact|   
    