Feature: Validating the Support Page


@Regression   @TC_01       @Support_Page1
Scenario Outline: Verify the support Page

Given   User Navigate to Open Url
When    User enter "<Username>" and "<Password>" by click on Sign Button
Then    User Login SUcessfullY
And     User Verify Home Page Functionlity

Examples:

|Username|Password|
|admin|admin|

@Regression   @TC_02       @Support_Page2
Scenario Outline: Verify the support Page

Given   User Navigate to Open Url
When    User enter "<Username>" and "<Password>" by click on Sign Button
Then    User Login SUcessfullY
And     User Verify Home Page Functionlity
And     User verify the Support Page
And     User verify and create Account in Support Page

Examples:

|Username|Password|
|admin|admin|

@Regression   @TC_03       @Support_Page3
Scenario Outline: Verify the support Page

Given   User Navigate to Open Url
When    User enter "<Username>" and "<Password>" by click on Sign Button
Then    User Login SUcessfullY
And     User Verify Home Page Functionlity
And     User verify the Support Page
And     User verify and create Account in Support Page
And     User verify the EditMass Page Functionlity

Examples:

|Username|Password|
|admin|admin|


@Regression   @TC_04       @Support_Page4
Scenario Outline: Verify the support Page

Given   User Navigate to Open Url
When    User enter "<Username>" and "<Password>" by click on Sign Button
Then    User Login SUcessfullY
And     User Verify Home Page Functionlity
And     User verify the Support Page
And     User verify and create SendEmail in Contact Page


Examples:

|Username|Password|
|admin|admin|























