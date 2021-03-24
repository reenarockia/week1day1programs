Feature: LeafTaps Edit lead functionality

Scenario Outline: TC003-01: Edit lead's company searching by First Name
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
And Click on Find leads link
Then Verify Find Leads page is displayed
Given Enter First Name as <firstName> in Find Leads page
When Click on Find Leads button
And Click on the first resulting Lead ID
Then Verify whether we landed on View Lead page 
And Verify whether the first name is <firstName> as given in Find Leads page
And Get the Company name as oldCompanyName
When Click on Edit Button in View Lead page 
Then Verify whether the Edit Lead page is displayed
Given Clear the Company Name
And Enter New Company Name as <newCompanyName>
When Click on Update button
Then Verify whether the company Name of the lead <firstName> displayed as <newCompanyName> in the View Lead page

Examples:

|firstName|newCompanyName|
|'Reena'|'Amazon'|
|'John'|'Zoho'|