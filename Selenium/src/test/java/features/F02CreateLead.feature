Feature: LeafTaps create lead functionality

Scenario Outline: TC002-1: Create lead with mandatory fields
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
And Click on Create Lead link
Then Verify Create Lead page is displayed
Given Enter Company Name as <companyName>
And Enter First Name as <firstName>
And Enter Last Name as <lastName>
When Click on Create Lead button
Then Verify whether the view Lead page is displayed with given <companyName>,<firstName>,<lastName>

Examples:
|companyName|firstName|lastName|
|'HCL'|'Reena'|'Arockiasamy'|
|'CTS'|'John'|'A'|
|'TCS'|'Jone'|'John'|

Scenario Outline: TC002-2: Create lead with email ID and phone number fields
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
And Click on Create Lead link
Then Verify Create Lead page is displayed
Given Enter Company Name as <companyName>
And Enter First Name as <firstName>
And Enter Last Name as <lastName>
And Enter email Id as <emailId>
And Enter Phone Number as <phoneNumber>
When Click on Create Lead button
Then Verify whether the view Lead page is displayed with given <companyName>,<firstName>,<lastName>

Examples:
|companyName|firstName|lastName|emailId|phoneNumber|
|'HCL'|'Reena'|'Arockiasamy'|'reen@gmail.com'|'+9840818049'|
|'CTS'|'John'|'A'|'johna@gm.com'|'+1111111111'|
|'TCS'|'Jone'|'John'|'joneJ@gmail.com'|'+2222222222'|