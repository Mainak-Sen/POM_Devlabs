@E2E
Feature: Creating and Updating Incident
@Prerequisite
Scenario Outline: User should log in and verify the incident ID
Given The URL is launched.
When User logs in with "<username>" and "<password>" and clicks on login button.
And User types "<filter>" in the search bar.
And User clicks on Create New option in the desired category.
And The value in Incident field is recorded.
Then The value must start with "<data>"

Examples:
|username|password          |filter  |data|
|admin   |MunnahServiceNow@1|incident|INC |

@IncidentValidation
Scenario Outline: Create an incident providing the necessary details and check if its getting updated successfully
Given User clicks on Caller Search
When User chooses caller as "<Caller>"
And category as "<Category>"
And SubCategory as "<sub-category>"
And ContactType as "<ContactType>"
And User enters a "<short description>"
And User submits the incident
And User searches for the stored incident and checks the displayed field values
Then The details "<Caller>","<Category>","<sub-category>","<ContactType>","<short description>" should reflect as expected 
When User updates the description again to "<new description>" 
Then Description should  successfully reflect as "<new description>"
Examples:
|Caller    |Category|sub-category    |ContactType|short description               |new description                 |
|Abel Tuter|Software|Operating System|phone      |This is a high priority incident|This is the updated description.|

