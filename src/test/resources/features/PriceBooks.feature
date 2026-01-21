Feature: Validating to the PriceBook Functionlity



@Regression  @PriceBook1   @Tc_001
Scenario Outline: verify the PriceBook Functionality

 Given User Navigate to Application URLL
 When  User enter "<UserName>" and "<Password>" by click on SignIN Button
 Then  User SigIN Sucessfully
 And   User verify the HomePage Title
 And   User Able to click on Inventory Tab
 And   User Able to click on priceBook
 
 Examples:
 
 |UserName|Password|
 |admin|admin|
 
 @Regression  @PriceBook2   @Tc_002
Scenario Outline: verify the PriceBook Functionality

 Given User Navigate to Application URLL
 When  User enter "<UserName>" and "<Password>" by click on SignIN Button
 Then  User SigIN Sucessfully
 And   User verify the HomePage Title
 And   User Able to click on Inventory Tab
 And   User Able to click on priceBook
 And   User verify and creating New"<PriceBook>" PriceBook
 
  Examples:
 
 |UserName|Password|PriceBook|
 |admin|admin|TestBook|
 
  @Regression  @PriceBook3   @Tc_003
Scenario Outline: verify the PriceBook Functionality

 Given User Navigate to Application URLL
 When  User enter "<UserName>" and "<Password>" by click on SignIN Button
 Then  User SigIN Sucessfully
 And   User verify the HomePage Title
 And   User Able to click on Inventory Tab
 And   User Able to click on priceBook
 And User verify the PriceList in PriceBook
 
 
  Examples:
 
 |UserName|Password|
 |admin|admin|
 
 
 
 
 
 
 