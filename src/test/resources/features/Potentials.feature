Feature: Validating the Potentials Functionlity


@Regression  @Potentials_1    @TC001
Scenario Outline: User verify the Potentials Page Functionlity

Given User Launch and Open Url
When  User login with UserName"<Uname>" and Passord"<pwd>" click on SignIn Button
Then  User able to login Sucessfully
And   User verify Vitger Home Page
And   User verify Pop message in Potentials page

Examples:

|Uname|pwd|
|admin|admin|
