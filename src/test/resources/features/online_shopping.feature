Feature: Registration functionality on E-commerce online shopping website

  Background:
    Given initialize the browser with chrome
    And    navigates to "url" site
  # And   verify the title of the homepage

  Scenario Outline: As a user I want to register or sign in on website
    When  user clicks on Sign-in link
    And   enters "<email_id>" in create an account section and clicks the button
    And   verify the title of registration page
    Then  clicks on Registration button
    And   verify that the user is registered successfully

    Examples:
      | email_id                 |
      | testAutomation@gmail.com |


  Scenario Outline: As a user I want to log in into My Account
    When  I clicks on Sign-in link
    And   enters "<email_id>" and "<password>"
    Then  clicks on sign in button
    And   user should be logged in successfully

    Examples:
      | email_id                 | password  |
      | testAutomation@gmail.com | test@1234 |


  Scenario Outline: As a user I want to search for the product and add it to cart
    When I clicks on search text box
    And  search for "<productName>" product
    Then similar product list should be displayed
    And  I sort the product using category
    And I navigate to the particular product
    Then I click on Add to cart button

    Examples:
      | productName |
      | printed     |
  # | dresses     |
  #  | tops        |




