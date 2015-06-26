Feature: Add Video Action

Scenario Outline: Successful Add Video
	Given User user is logged in with username "<username>" and password "<password>"
	When User Left clicks Contribute button
	And User Left clicks Add a video button 
	And User types video url "<video_url>" from youtube into the Video URL field 
	And User Left clicks Add button 
	And User Left clicks link to file "<filename>" on the flash message
	Then Verify "<filename>" and flash message matches
	
	Examples:
	| username | password     | video_url  | filename | 
	| Payal08  | password#123 | https://www.youtube.com/watch?v=hsSB9r6w3Mo | Afrojack & Steve Aoki feat. Miss Palmer - No Beef official video 2011 |