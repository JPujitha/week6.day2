Feature: Duplicate Lead
@smoke
Scenario Outline: Duplicate Leads
Given Click find leads
Then Click phone 
Given Enter phone number <PhoneNumbertoedit>
Then Click on find leads
Then Click on first lead id
Then Click on duplicare lead
Given Click 'submitButton'
Examples:
|PhoneNumbertoedit|
|'123'|
|'98'|