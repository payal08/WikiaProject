Feature: Login Action

Scenario Outline: Successful User Login
	Given User navigates to Wiki Home page
	When User hovers mouse over Log In label
	And User enters "<username>" and "<password>" and clicks Log In button 
	Then User is successfully logged in, "<username>" is displayed
	
	Examples:
	| username | password     |
	| Payal08  | password#123 |
	