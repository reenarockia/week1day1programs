Feature: LeafTaps Duplicate lead functionality

Scenario Outline: TC004: Create Duplicate Lead Record by searching through emailID
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
And Click on Find leads link
Then Verify Find Leads page is displayed
Given Enter the email Id of the lead to be duplicated as <emailId>
When Click on Find Leads button
And Click on the first resulting Lead ID
Then Verify whether we landed on View Lead page
Then Store the OriginalLeadFirstName
When Click on Duplicate Lead button
Then Verify Duplicate Lead page is displayed
When Click on Create Lead button in Duplicate Lead page 
Then Verify whether we landed on View Lead page
Then Verify whether the DuplicatedLeadFirstName is same as that of the OriginalLeadFirstName

Examples: 
|emailId|
|'johna@gm.com'|