Feature: Validating the Assets Functionlity

@Regrssion   @Assets_1   @TC_001
Scenario Outline: Verify the Assets Functionlity Page

Given User navigate the Application URL
When  User enter userName"<Uname>" and password"<Pwd>" by click on Sign In Button
Then  User Login the Application
And   User IS in Home Page
And   User create a Assets page

Examples:

|Uname|Pwd|
|admin|admin|

