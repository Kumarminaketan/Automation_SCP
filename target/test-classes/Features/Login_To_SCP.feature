Feature: Log in to SCP QA homepage 
@Completed
Scenario: User able to login to the SCP QA site
Given User is on SCP Login page
When User login with correct User name  and Pasword
Then Verify that CV home page should be displayed
And click on the DLP tab

@Completed
Scenario: Verify that the plant and material details are displayed for respective month
Given Select the vendor
When user select the month
Then Verify that the material details should be displayed
And Verify the partcode details 
And Verify the partcode description
#And Verify the Inward consumption
#And Verify the Commitment
#And Verify the Shortfall



