Feature: Assign Incident Positive Scenario
@assign
Scenario: Assign Incident
	Given Click on All
	When Apply with 'state'
	When Enter filter value as 'New'
	Then Select first resultant incident 
	And Find Id and store it
	And Click to search assignment group
	And In groups click 'Software'
	And Enter worknotes as 'Test'
	Given click update
	When Apply with  the 'number'
	When Enter filter value 'ID'
	Then Select first resultant incident 
	And Get the assignment_group
	Then Verify the assignment is successfull or not with 
	