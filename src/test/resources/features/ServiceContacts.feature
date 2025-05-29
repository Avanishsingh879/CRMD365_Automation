Feature: Validating the ServiceContact page Functionlity



@Regression @ServiceContact  @Tc_001
Scenario Outline: Verify the ServiceContact Page

 Given User Navigate to Launch Application
 When  User enter "<Uname>" and "<Password>" by click on Login Page
 Then  User verify Login Page
 And   User verify the Home Page Functionlity
 And   User verify and create new ServiceContact"<Subject>" Page
 
 Examples:
 
 |Uname|Password|Subject|
 |admin|admin|Test|