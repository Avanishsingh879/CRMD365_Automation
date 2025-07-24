Feature: Validating the Vendor Page Functionlity

@ignore
@Regression  @Ven_01  @Tc_001
Scenario Outline: Verify the the Vendor Functionlity

Given I Navigate to open Application Url
When User enter username "<Uname>" and password "<pwd>" by click on Login Button
Then User Login
And  User able to verify Home Page Functionlity
And User verify the Vendor Tab

Examples:

|Uname|pwd|
|admin|admin|


@Regression  @Ven_02  @Tc_002
Scenario Outline: Verify the the Vendor Functionlity

Given I Navigate to open Application Url
When User enter username "<Uname>" and password "<pwd>" by click on Login Button
Then User Login
And  User able to verify Home Page Functionlity
And User verify the Vendor Tab
And  User verify VendorList in Vendor Page

Examples:

|Uname|pwd|
|admin|admin|


