Feature: Validating the various components of the UI 
@UI
Scenario Outline: User should log in and search for the required filter-data
Given The URL is launched.
When User logs in with "<username>" and "<password>" and clicks on login button.
And User types "<filter>" in the search bar.
And User clicks on All button
Then User should be able to see the New Button
And User should be able to see the dropdown of search
And By default "<drop_value>" should be selected in drop-down
And In the search text-box placeholder value should be "<plHolder>"
And Table header should have the following in order
|Number|Opened|Short description|Caller|Priority|State|Category|Assignment group|Assigned to|Updated|Updated by|

Examples:
|username|password          |filter  |drop_value|plHolder|
|admin   |MunnahServiceNow@1|incident|Number    |Search  |