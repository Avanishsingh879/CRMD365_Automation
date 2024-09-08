Feature: Validating Analytics page
   

@Regression   @Analytics_01  @TC_001
  Scenario: verify the Analytics Page
    Given I navigate to APPlication open UrL
    When User eneter username and password by click on Sign In Page
    Then User Login Sucessfully
    And User verify Home Page Functionlity
    And User able to click Analytics Tab
    
  @Regression   @Analytics_02  @TC_002  
 Scenario: verify the Analyics Page
    Given I navigate to Application open Url
    When User eneter username and password by click on Sign In Page
    Then User Login Sucessfully
    And User verify Home Page Functionlity
    And User verify Report Page Functionlity
   
 @Rrgression @Analytics_03 @Tc_003   
 Scenario Outline: verify the Analyics Page
  
  Given I navigate to Application open Url
  When User eneter username and password by click on Sign In Page
  Then User Login Sucessfully
  And User verify Home Page Functionlity
  And User verify Report Page Functionlity
  And User verify and Create Report"<ReportName>","<Description>" in Report Page Functionlity
  
  Examples:
  
  |ReportName|Description|
  |Test1     |    Testing|
  
    
     