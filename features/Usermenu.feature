Feature: Usermenupage features of the SalesForce application

  Scenario: Select User menu for username drop down
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "march@solutions.com"
    And User enter into Textbox "Password" "Training123 "
    And User clicks on element "Login"
    Given User is on the "UserMenuPage"
    When User clicks on element "Usermenu"
    Then Assert link in "UserNavMenuItems"
      | My Profile                     |
      | My Settings                    |
      | Developer Console              |
      | Switch to Lightning Experience |
      | Logout                         |

  Scenario: Select My Profile from username drop down
    Given User is on the "LoginPage"
    When User enter into Textbox "Username" "march@solutions.com"
    And User enter into Textbox "Password" "Training123 "
    And User clicks on element "Login"
    Given User is on the "UserMenuPage"
    When User clicks on element "Usermenu"
    And User clicks on element "MyProfile"
    Given User is on the "MyProfilePage"
    When User clicks on element "EditProfileButton"
    Given User is on the "EditProfileFramePage"
    Then Assert list in "EditProfileFrame"
      | About   |
      | Contact |
    When User clicks on element "About"
    And User enter into Textbox "Lastname" "Soman"
    And User clicks on element "SaveAllButton"
    Given User is on the "MyProfilePage"
    Then Assert: "Title" with title "User: Sherin Soman ~ Salesforce - Developer Edition"
    
