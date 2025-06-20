Feature: Validating the Assets Functionlity


@Regression  @Asstes_1     @TC_001
Scenario Outline: User verify the Assets Page Functionlity

Given User open and Navigate Application Url
When  User enter UserName"<Uname>" and Password"<Pwd>" by click on SignIn Page
Then User Verify Page Title
And  User verify and Create Asstes

Examples:
|Uname|Pwd|
|admin|admin|

@Regression  @Asstes_2     @TC_001
Scenario Outline: User verify the Assets Page Functionlity

Given User open and Navigate Application Url
When  User enter UserName"<Uname>" and Password"<Pwd>" by click on SignIn Page
Then User Verify Page Title
And  User verify All Asstes in AsstesList Page 

Examples:
|Uname|Pwd|
|admin|admin|

