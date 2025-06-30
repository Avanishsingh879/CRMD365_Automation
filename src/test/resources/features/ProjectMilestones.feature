Feature: Validating the ProjectMilestones Functionlity


@Regression   @ProjectMiles   @Tc_001
Scenario Outline: Verify the ProjectMilestones Page deatils

Given  User open and Navigate the Application Url
When   User login with usernme"<Username>" and password"<Pwd>" by click on Login Page
Then   User able to Login sucesfully
And    User able to verify the Home page deatils
And    User able to click on PrpjectMilesTones Tab

Examples:

|Username|Pwd|
|admin|admin|


@Regression   @ProjectMiles_1   @Tc_001
Scenario Outline: Verify the ProjectMilestones Page deatils

Given  User open and Navigate the Application Url
When   User login with usernme"<Username>" and password"<Pwd>" by click on Login Page
Then   User able to Login sucesfully
And    User able to verify the Home page deatils
And    User able to click on PrpjectMilesTones Tab
And    User verify the List of projectMilesTone in List

Examples:

|Username|Pwd|
|admin|admin|