Feature: Validating the Vendor Functionlity


@Regression  @Vendor  @TC_001   
Scenario Outline: Verify the Vendor Functionlity

Given User navigate to launch Browser

When  User Login with "<Username>" and "<Password>" by click on Login Tab

Then  User able to login sucessfully

And   User Home page Functionlity

And   User Able to click on Vendor Tab

Examples:

|Username|Password|
|admin|admin|


@Regression  @Vendor1  @TC_002  
Scenario Outline: Verify the Vendor Functionlity

Given User navigate to launch Browser

When  User Login with "<Username>" and "<Password>" by click on Login Tab

Then  User able to login sucessfully

And   User Home page Functionlity

And   User Able to click on Vendor Tab

And   User Verify the List Data in Vendor

Examples:

|Username|Password|
|admin|admin|