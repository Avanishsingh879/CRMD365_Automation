Feature: Validating to the FeedBackFrom Page


@Regression  @Feddback     @TC_001
Scenario: User Verify the Feedback From

  Given User navigate the Application Url
  When User enter username and password by click on SingIn Page
  Then User Login Sucessfully
  And User verify Home Page functionlity
  And User verify the Bug DropDown List FeedBack Page
  
@Regression  @Feddback_2     @TC_00@
Scenario Outline: User Verify the Feedback Form
 
 Given User navigate the Application Url
 When User enter username and password by click on SingIn Page
 Then User Login Sucessfully
 And User verify Home Page functionlity
 And User verify the "<Description>","<Email>"Sugesstion Button in Feedback Form
 
 Examples:
 
 |Description|Email|
 | Test|   Test@gmail.com|
 
 
 
 
 
  
