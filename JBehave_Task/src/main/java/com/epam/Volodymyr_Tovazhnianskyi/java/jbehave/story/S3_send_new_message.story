Narrative:
User login in his account
When user tries to send new message
Message should be send
      
Scenario: Check sending message

Given user logged in with tmail007 and SuperPassword and on Write New Message page
When try to send data to fields and click button (adress: <targetEmail>, theme: <theme>, message: <message>)
Then letter should be send

Examples:
|targetEmail|theme|message|
|tmail007@mail.ru|WTS|WTB|