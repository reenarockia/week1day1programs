Feature: LeafTaps Delete lead functionality

Scenario Outline: TC006: Delete Lead Record by searching through phoneNumber
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
When Click on Find leads link
Then Verify Find Leads page is displayed
Given Enter LeadPhoneNumber as <leadPhoneNumber>
When Click on Find Leads button
And Click on the first resulting Lead ID
Then Verify whether we landed on View Lead page
Then Store the OriginalLeadId
When Click on Delete button
Then Verify whether we landed on My Leads Page
When Click on Find leads link
Then Verify Find Leads page is displayed
Given Enter Lead Id OriginalLeadId
When Click on Find Leads button
Then Verify NoRecordsMessage is displayed

Examples:
|leadPhoneNumber|
|'9840818049'|