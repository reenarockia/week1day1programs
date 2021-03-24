Feature: Login functionality in LeafTaps application

#Background: 
#Given Open the Chrome Browser
#And Load the URL


Scenario Outline: TC001-01 - Login with valid credentials(Positive TC)
Given Enter username as <username>
And Enter password as <password>
When Click on Login button
Then HomePage should get displayed

Examples:
|username|password|
|'demosalesmanager'|'crmsfa'|
|'demoCSR'|'crmsfa'|

Scenario: TC001-02 - Login with invalid Credentials(Negative TC)
Given Enter username as 'demosalesmanager'
And Enter password as 'crmsfa123'
When Click on Login button
But Error Message should get displayed
