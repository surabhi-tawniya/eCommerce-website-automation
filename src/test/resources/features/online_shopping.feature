Feature: Registration functionality on E-commerece online shopping website

  Scenario: As a user I want to register or sign in
    Given browser is open
    When user navigates to url {string}
    And  verifying that the home page is visible successfully
    And user clicks on Sign-in link
    And user enters email id in create an account section
    And clicks create an account button
    When user enters his personal information
    And  clicks on Registration button
    Then user created successfully






