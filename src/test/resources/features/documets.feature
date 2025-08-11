Feature: Validating the Documets Functionlity


@Regression  @Documets_01   @Tc_001
Scenario Outline: Verify the documets functionlity

Given User open the Application URL

When User enter Uname"<UserName>" and Paaswrd "<Password>" by click on Login Button

Then user able to Login Sucessfully

And  User able to Verify the Home page Functionlity

And  User able to click on Documemts Tab

Examples:


|UserName|Password|
|admin|admin|

@Regression  @Documets_02   @Tc_001
Scenario Outline: Verify the documets functionlity

Given User open the Application URL

When User enter Uname"<UserName>" and Paaswrd "<Password>" by click on Login Button

Then user able to Login Sucessfully

And  User able to Verify the Home page Functionlity

And  User able to click on Documemts Tab

And  User verify the Documets List in ListData

Examples:


|UserName|Password|
|admin|admin|
