Feature: Validating the Quotes Page Funcionlity


@Regression   @quotes_01   @tc_001
Scenario Outline: verify the Quotes Page Functionlity

Given user Navigate to Application url

When User enter UserName"<Uname>" and passWord"<pwd>" by click on Login Button

Then user able to login Sucessfully

And  user verify the home page functionlity

And  user able to click quotes tab

Examples:

|Uname|pwd|
|admin|admin|


@Regression   @quotes_02   @tc_001
Scenario Outline: verify the Quotes Page Functionlity

Given user Navigate to Application url

When User enter UserName"<Uname>" and passWord"<pwd>" by click on Login Button

Then user able to login Sucessfully

And  user verify the home page functionlity

And  user able to click quotes tab

And user verify the QuotesList in Quotes

Examples:

|Uname|pwd|
|admin|admin|