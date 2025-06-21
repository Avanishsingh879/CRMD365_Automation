Feature: Verify SalesOrder Page Functionlity


@Regression  @Sales_Order  @Tc_001
Scenario Outline: User Create and Verify SalesOrder

Given User Open and Navigate to Application Url
When  User Enter userName"<userName>" and Password"<passwd>" by click on Login Button
Then  User able to Login Sucessfully
And   User able to Verify Home Page Functionlity
And   User create and verify SalesOrder in Sales Page

Examples:

|userName|passwd|
|admin|admin|

@Regression  @Sales_Order_2  @Tc_001
Scenario Outline: User Create and Verify SalesOrder

Given User Open and Navigate to Application Url
When  User Enter userName"<userName>" and Password"<passwd>" by click on Login Button
Then  User able to Login Sucessfully
And   User able to Verify Home Page Functionlity
And   User create and verify SalesOrder in Sales Page
And   User create and Verify New SalesOrder"<Subject>","<BillingAddress>","<ShippingAddress>"

Examples:

|userName|passwd|Subject|BillingAddress|ShippingAddress|
|admin|admin|Test|Noida|Delhi|