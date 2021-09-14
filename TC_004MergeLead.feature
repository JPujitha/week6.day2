Feature: Merge Lead
@functional @regression
Scenario Outline:
Given Click on Merge Leads
Given Click on From Lead <fname1>
And Click on To Lead <fname2>
And Click on Merge Lead button
Given Click find leads
Given Enter the captured id
And check text
Examples:
|fname1|fname2|
|'a'|'b'|
|'g'|'d'|