Feature: Create Incident
@createincident
Scenario: Create incident
Given Click on CreateNew
And Click on search icon for caller and select name
Given Short description
And Captured Id
Given Click on submit
And Enter values in search
And Get the result incident ID 
Then compare both crated and result incident
 
