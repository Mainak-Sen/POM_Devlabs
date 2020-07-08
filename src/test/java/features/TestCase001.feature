Feature: Verify Incident ID
@Smoke
Scenario Outline: Login to instance and verify Incident ID
Given The URL is launched.
When User logs in with "<username>" and "<password>" and clicks on login button.
And User types "<filter>" in the search bar.
And User clicks on Create New option in the desired category.
And The value in Incident field is recorded.
Then The value must start with "<data>"

Examples:
|username|password          |filter  |data|
|admin   |MunnahServiceNow@1|incident|INC |