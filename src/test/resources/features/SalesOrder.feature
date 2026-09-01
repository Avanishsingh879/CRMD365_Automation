Feature: Validating the SalesOrder Functionlity Page

@Regression   @SalesOrder_1  @TC_01
Scenario Outline: Validate the SalesOrder

Given  User Navigate the Application Url
When   User Enter username"<Uname>" and Password"<Pwd>" by click on Sign Button
Then   User Login Sucessfully page
And    User Verify Title in Home Page

Examples:

|Uname|Pwd|
|admin|admin|


@Regression   @SalesOrder_2  @TC_02
Scenario Outline: Validate the SalesOrder

Given  User Navigate the Application Url
When   User Enter username"<Uname>" and Password"<Pwd>" by click on Sign Button
Then   User Login Sucessfully page
And    User Verify Title in Home Page
And    User Verify and create Sales Order

Examples:

|Uname|Pwd|
|admin|admin|

