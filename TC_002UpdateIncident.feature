Feature: Update Incident Positive Scenario
@Update
Scenario: Update Incident
Given Click on All
When Apply with 'state'
When Enter filter value as 'New'
Then Select first resultant incident 
Given Chnage state 
Given Change Urgency
Given Check if update is successfull
Given click update