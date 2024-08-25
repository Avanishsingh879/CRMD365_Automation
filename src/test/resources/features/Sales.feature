Feature: Validating Sales page
   

@Regression   @Create_Sales  @TC_001
 Scenario: verify the Vtiger Login Page
    Given I navigate to application open URl
    When User Enter Username and Password By click on Login button
    Then Login sucessfullY
    And User is in VtigerCRM home page
    And User has click on Sales tab
    And User has click on Leads tab
    And User verify the Creating Leads in Sales by click on Save button
    And User verify the checked AllCheck List in Sales page
    And User verify and Delete checklist in Sales page
    And User verify Alert pop up deleting checklist in Sales page
    
 @Regression  @Verify_Sales_SendMails  @TC_002
 Scenario: verify the Vtiger Login Page
    Given I navigate to application open URl
    When User Enter Username and Password By click on Login button
    Then Login sucessfullY
    And User is in VtigerCRM home page
    And User has click on Sales tab
    And User has click on Leads tab
    And User verify the Creating Leads in Sales by click on Save button
    And User verify the checked AllCheck List in Sales page
    And User verify and Select checklist in Sales page
    And User has click on Sendmail Tab
    
@Regression  @Verify_Sales_Accounts @TC_001   
 Scenario: verify the Vtiger Sales_Accounts Pages
    Given I navigate to application open URl
    When User Enter Username and Password By click on Login button
    Then Login sucessfullY
    And User is in VtigerCRM home page
    And User has click on Sales tab
    And User has click on Accounts tab
    And User verify the Creating Accounts in Sales by click on Save button
    

    
    
    
    