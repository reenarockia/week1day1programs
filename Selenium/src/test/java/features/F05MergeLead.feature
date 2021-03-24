Feature: LeafTaps Merge lead functionality

Scenario Outline: TC005: Merge Lead Records by searching through phoneNumber
Given Enter the username as demoCSR
And Enter the password as crmsfa
When Click on login button
Then Home page should get displayed
When Click on CRMSFA link
And Click on Leads link
And Click on Merge Leads link
Then Verify Merge Leads page is displayed
When Click on Lookup button of From Lead
Then Switch to the new window that opens up
Then Verify whether the title is Find Leads
Given Enter lead Id <leadId1>
When Click on Find Leads button
And Click on the resulting Lead Id
And Switch back to the ParentWindow
Then Verify Merge Leads page is displayed
When Click on Lookup button of To Lead
Then Switch to the new window that opens up
Then Verify whether the title is Find Leads
Given Enter lead Id <leadId2>
When Click on Find Leads button
And Click on the resulting Lead Id
And Switch back to the ParentWindow
Then Verify Merge Leads page is displayed
When Click on Merge button
And Accept the Alert
Then Verify Merge Leads page is displayed
When Click on Find leads link
Then Verify Find Leads page is displayed
Given Enter Lead Id1 <leadId1>
When Click on Find Leads button
Then Verify NoRecordsMessage is displayed <leadId1>,<leadId2> 

Examples:

|leadId1|leadId2|
|'10069'|'10767'|


