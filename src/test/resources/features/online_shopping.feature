Feature: Registration functionality on E-commerce online shopping website

  Background:
    Given initialize the browser with chrome
    And    navigates to "url" site
    And   verify the title of the homepage

  Scenario: As a user I want to register or sign in on website
    When  user clicks on Sign-in link
    And   enters email_id in create an account section and clicks the button
    And   user enters his personal information
    Then  clicks on Registration button
    And   verify that the user is registered successfully


  Scenario Outline: As a registered user I want to log in into my account
    When  I clicks on Sign-in link
    And   enters <email_id> and <password>
    Then  clicks on sign in button
    And   user should be logged in successfully

    Examples:
      | email_id          | password |
      | abcd123@gmail.com | abcd1234 |

