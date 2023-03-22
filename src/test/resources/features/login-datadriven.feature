Feature: User Authentication

  As a user
  I want to be able to sign in
  So that I can access my account

  @datadriven
  Scenario Outline: testing login feature
    Given I am on the application Landing Page
    When I Navigate to the Sign In Page
    And I enter the username as "<username>"
    And I enter the password as "<password>"
    And I click the Sign In Button
    Then I should see the message "<expectedmessage>"

    Examples:
      | username          | password             | expectedmessage                |
      | tomsmith          | SuperSecretPassword! | You logged into a secure area! |
      | incorrectusername | incorrectpassordf    | Your username is valid!      |