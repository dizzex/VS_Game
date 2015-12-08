Narrative:
User tries to login into account
When login process is finished
Check if user is really logged in
      
Scenario: Check login in process

Given user login is tmail007 and password is SuperPassword
When user tries to login into account
Then there should be menu options