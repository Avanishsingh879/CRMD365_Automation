Feature: Validating FaQ Functionlity


@Regression   @TC_001   @FaQ
Scenario Outline: Verify the FaQ Page Functionlity

   Given User Navigate to Open URl Application
   When  User Enter "<UserName>" and "<Password>" by click on Login Button
   Then User Login SucessfullY
   And User is In Home page 
   And User able to click on Support tab
   And User able to click on Contacts tab
   And User able to click FaQ Tab
   And User able to verify List in FAQ List
   
   Examples: 
   
   |UserName|Password|
   |admin|admin|

