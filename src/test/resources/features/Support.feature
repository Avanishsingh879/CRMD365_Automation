Feature: Validating Support page


@Regression   @Support   @TC_1
Scenario: Verify the Support

Given User Navigate the Open URL
When  User Enter username and password by click on SignIN Button
Then  User Login Sucessfully Page
And   User Verify the HomePage Functionlity
And   User Able to click on Support Tab


@Regression @Support_2    @TC_2
Scenario: verify the Account tab in Support Page

Given User Navigate the Open URL
When  User Enter username and password by click on SignIN Button
Then  User Login Sucessfully Page
And   User Verify the HomePage Functionlity
And   User Able to click on Support Tab
And   User Able to click on Account Tab



