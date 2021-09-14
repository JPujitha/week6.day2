Feature: Delete Lead
@sanity
Scenario Outline: Delete Leads
Given Click find leads
Then Click phone 
Given Enter phone number <PhoneNumbertoedit>
Then Click on find leads
Then Capture the first lead
Then Click on first lead id
Then Click on delete lead
Given Click find leads
Given Enter the captured id
Then Compare text
Examples:
|PhoneNumbertoedit|
|'123'|
|'98'|