Feature: Login scenarios of the SalesForce application

  Scenario: Login into SaleForce application without password
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "march@solutions.com"
    And User enter into Textbox "Password" ""
    And User clicks on element "Login"
    Then Assert: Message should be displayed "ErrorMessage" "Please enter your password."

  Scenario: Login into SaleForce application with valid username and password
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "march@solutions.com"
    And User enter into Textbox "Password" "Training123"
    And User clicks on element "Login"
    Given User is on the "HomePage"

  Scenario: Login into SaleForce application by checking RememberMe checkbox
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "march@solutions.com"
    And User enter into Textbox "Password" "Training123"
    And User clicks on element "Checkbox"
    And User clicks on element "Login"
    Given User is on the "UserMenuPage"
    When User clicks on element "Usermenu"
    And User clicks on element "Logout"
    Given User is on the "LoginPage"
    Then Assert "Username" with name displayed "march@solutions.com"

  Scenario: Test the Forgot Password caseA
    Given User is on the "LoginPage"
    When User clicks on element "ForgotPassword"
    Given User is on the "ForgotPasswordPage"
    When User enter into Textbox "ForgotPasswordUsername" "sherinsoman@gmail.com"
    And User clicks on element "ContinueButton"
    Then Assert: Message should be displayed "CheckYourEmailMessage" "Check Your Email"

  Scenario: Test the Forgot Password caseB
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "123"
    And User enter into Textbox "Password" "22131"
    And User clicks on element "Login"
    Then Assert: Message should be displayed "ErrorMessage" "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
