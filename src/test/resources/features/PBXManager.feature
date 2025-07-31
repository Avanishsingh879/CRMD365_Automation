Feature: Validating the PBXmanager page functionlity


@Regression  @PXBManger_01   @TC001
Scenario Outline: Verify the PBXmanger page Funcionlity

Given User open the Application Url

When User enter ussername"<UserName>" and password "<Pwd>" by click on SignIn Button

Then  User able to Login sucessfilly

And  User Verify the HomePage Data

And  User able to click on PBXMager tab

Examples:

|UserName|Pwd|
|admin|admin|

@Regression  @PXBManger_02   @TC001
Scenario Outline: Verify the PBXmanger page Funcionlity

Given User open the Application Url

When User enter ussername"<UserName>" and password "<Pwd>" by click on SignIn Button

Then  User able to Login sucessfilly

And  User Verify the HomePage Data

And  User able to click on PBXMager tab

And User verify the PBXMager data in PBXMagerList

Examples:

|UserName|Pwd|
|admin|admin|


