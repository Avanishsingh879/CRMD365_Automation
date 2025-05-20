Feature: Verify Documents Page


@Docuements @Docuements_01  @Tc_001
 Scenario: Verify Docuemts Page Functionlity
 
 Given User Navigate To Application URL
 When User Enter UserName and Password by Click on Sign In Button
 Then User Login SucessFully
 And  User Is in home Page
 And  User has click on marketing Tab
 And User has click on account Tab
 And User has click on documents Tab
 
 @Docuements @Docuements_02  @Tc_002
 Scenario: Verify Docuemts Page Functionlity
 
 Given User Navigate To Application URL
 When User Enter UserName and Password by Click on Sign In Button
 Then User Login SucessFully
 And  User Is in home Page
 And  User has click on marketing Tab
 And User has click on account Tab
 And User has click on documents Tab
 And User Move to Folder in Document
 
 @Docuements @Docuements_03  @Tc_002
 Scenario Outline: Verify Docuemts Page Functionlity
 
 Given User Navigate To Application URL
 When User Enter UserName and Password by Click on Sign In Button
 Then User Login SucessFully
 And  User Is in home Page
 And  User has click on marketing Tab
 And User has click on account Tab
 And User has click on documents Tab
 And User Add "<Title>","<FileName>" in Documents Functionlity
 
 Examples:
 |Title|FileName|
 |QA|doc1|
 
  @Docuements @Docuements_04  @Tc_002
 Scenario: Verify Docuemts Page Functionlity
 
 Given User Navigate To Application URL
 When User Enter UserName and Password by Click on Sign In Button
 Then User Login SucessFully
 And  User Is in home Page
 And  User has click on marketing Tab
 And User has click on account Tab
 And User has click on documents Tab
 And User the Quickcreate List in Quickcreate Page
 
   @Docuements @Docuements_05  @Tc_002
 Scenario: Verify Docuemts Page Functionlity
 
 Given User Navigate To Application URL
 When User Enter UserName and Password by Click on Sign In Button
 Then User Login SucessFully
 And  User Is in home Page
 And  User has click on marketing Tab
 And User has click on account Tab
 And User has click on documents Tab
 And User Verify the List of Documents in Documents Page
 
 
 
 
 
 
 