Feature: Validating Helpmate flows for Genpact Home page
   

@Regression   @Vtiger_10  @Tc_001
  Scenario: verify the Vtiger Login Page
   Given I navigate to application Open URL
    When User Enter Username and Password by click on Login Button
    Then Login Sucessfully
    And User is in VtigerCRM Home Page