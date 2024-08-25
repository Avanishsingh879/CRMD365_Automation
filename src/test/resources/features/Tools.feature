Feature: Validating Tools page
   

@Regression   @Tools_1  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application Open URl
    When User Enter Username and Password by click On login Button
    Then Login SucessfullY
    And User is in vtigerCRM Home page
    And User has click on Tools tab
    
@Regression   @Tools_2  @TC_002
  Scenario: verify the Vtiger Login Page
    Given I navigate to application Open URl
    When User Enter Username and Password by click On login Button
    Then Login SucessfullY
    And User is in vtigerCRM Home page
    And User has click on Tools tab
    And User verify the OurSites in Tools Page
  
@Regression @Tools_3   @TC_003  
Scenario: verify the Vtiger Login Page

   Given I navigate to application Open URl
   When User Enter Username and Password by click On login Button
   Then Login Sucessfully
   And User is in vtigerCRM Home page
   And User has click on Tools tab
   And User verify the Documents in Tools Page
   