Feature: Login Functionality

 # Scenario: Login with valid credentials
   # Given navigate to HRMS login page
    #When enter valid credentials
    #And click on login button
    #Then verify dashboard is displayed
    #And quit the browser

   Scenario: Login with invalid credentials
      Given navigate to HRMS login page
      When enter invalid credentials
      And click on login button
      Then verify error message
      And quit the browser

  Scenario: Login with empty username
    #Given navigate to HRMS login page
    When  only enter password
    And click on login button
    Then verify empty message
    #And quit the browser
@smoke
    Scenario: Login with empty password
     # Given navigate to HRMS login page
      When only enter username
      And click on login button
      Then verify password empty message
      #And quit the browser
