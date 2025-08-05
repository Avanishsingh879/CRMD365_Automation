Feature: Validating the Vendor Page Functionlity


@Regression  @Vendor_01  @TC001
Scenario Outline: Verify the Vendor Functionlity

Given User open the Appplication
When  User login application with UserName"<Uname>" and Password "<Pwd>" by click on Login Button
Then  user able to login sucessfully
And   User verify home Page Functinlity
And   User Able to click on Vendor Tab

Examples:

|Uname|Pwd|
|admin|admin|


@Regression  @Vendor_02  @TC001
Scenario Outline: Verify the Vendor Functionlity

Given User open the Appplication
When  User login application with UserName"<Uname>" and Password "<Pwd>" by click on Login Button
Then  user able to login sucessfully
And   User verify home Page Functinlity
And   User Able to click on Vendor Tab
And   User able to verify Vendor List in List 

Examples:

|Uname|Pwd|
|admin|admin|

