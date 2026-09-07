Feature: Validating the Service Page Functionlity

@Regression    @Service_01    @TC_001
Scenario Outline: Verify the Service Page funcltionlty in Inentory

Given User Navigate Application Url
When  User enter"<Uname>" and password "<Pwd>" by click on Sign button
Then  User Login Sucessfully Page
And   User verify Home Page title

Examples:
|Uname|Pwd|
|admin|admin|

@Regression    @Service_02    @TC_02
Scenario Outline:Verify the Service Page Functionlity in Inventory

Given User Navigate Application Url
When  User enter"<Uname>" and password "<Pwd>" by click on Sign button
Then  User Login Sucessfully Page
And   User verify Home Page title
And   User able to create a new Service Page

Examples:
|Uname|Pwd|
|admin|admin|




