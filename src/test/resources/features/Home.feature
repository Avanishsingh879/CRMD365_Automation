Feature: Validating to VtigerHome Page


@Regression @Home_test @TC_001
Scenario Outline: Verify the Vtiger Home Functionality
 Given I navigate to applicatIon open UrL
 When user Enter "<Username>" and "<Password>" by click on login Button
 Then User login sucessfully
 And user is in VTigerCRM Home page
 
 Examples:
 
 |Username|Password|
 |admin|admin|
 
 


 
 

