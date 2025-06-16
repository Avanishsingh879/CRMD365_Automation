Feature: Vallidating to the Service Page Functionlity


@Regression   @Service_01  @TC_01
Scenario Outline: Verify the Service Page

Given User open the Application
When  user login "<username>" and "<password>" by click on login tab
Then  user verify Home Page Item
And   user verify and create new Service page

 Examples:
 |username|password|
 |admin|admin|
 
 
 @Regression   @Service_02  @TC_01
Scenario Outline: Verify the Service Page

Given User open the Application
When  user login "<username>" and "<password>" by click on login tab
Then  user verify Home Page Item
And   user verify and create new Service page
And   user verify List of Service in ServiceList


 Examples:
 |username|password|
 |admin|admin|