Feature: Verify Marketing Page


@Marketing_1 @Marketing    @Tc_001
Scenario: Verify Marketing Page Functionlity

 Given User Navigate to Application URL
 When User Enter UserName and Password by click on Sign In Button
 Then User Login Sucessfully
 And  User Is in Home Page
 
 @Marketing_2 @Marketing_2  @Tc_002
 Scenario: Verify Marketing Page Functionlity
 
 Given User Navigate to Application URL
 When User Enter UserName and Password by click on Sign In Button
 Then User Login Sucessfully
 And  User Is in Home Page
 And  User has click on Marketing Tab
 And User has click on Account Tab
 And User verify and select Multiple Check box in Marketing Page
 
  @Marketing_2 @Marketing_3  @Tc_003
 Scenario: Verify Pop-up Message in Marketing Page
 
 Given User Navigate to Application URL
 When User Enter UserName and Password by click on Sign In Button
 Then User Login Sucessfully
 And  User Is in Home Page
 And  User has click on Marketing Tab
 And User has click on Account Tab
 And User verify the Pop up Alert message
 
 
 
 
 
 
 
