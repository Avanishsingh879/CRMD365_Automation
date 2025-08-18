Feature: Validating the Ssrvice Page Functionlity


@Regression   @Serv_01    @Tc_001
Scenario Outline: Verify the Service Functionlity

Given User navigate to open url

When  User able to Enter UserName"<Uname>" and Password"<Pwd>" by click on Login Button

Then  user Able to Login sucessfully

And   User Verify the home page functionliy Data

And   User verify and create service tab

Examples:

|Uname|Pwd|
|admin|admin|


@Regression   @Serv_02    @Tc_001
Scenario Outline: Verify the Service Functionlity

Given User navigate to open url

When  User able to Enter UserName"<Uname>" and Password"<Pwd>" by click on Login Button

Then  user Able to Login sucessfully

And   User Verify the home page functionliy Data

And   User verify and create service tab

And  User verify the ServiceList data in List

Examples:

|Uname|Pwd|
|admin|admin|




