Feature: Login into VR Shopping Site

Background: 	
	Given Open the chrome browser
	And load the application URL


@smoke
Scenario Outline: TC001_Login with valid credentials

	When enter the valid username "<username>"
	And enter the valid password "<password>"
	Then Click on login button

Examples:
|username|password|
|admin|admin123|
|admin|admin123|
	
@Regression	
Scenario: TC002_Login with Invalid credentials

	When enter the invalid username
	And enter the invalid password
	But Click on login button