Feature: User Authentication

  As a user
  I want to be able to sign in
  So that I can access my account

  @datadriven
  Scenario Outline: testing login feature
    Given I have launched the facebook app
    When I try to login using "<username>" and "<password>"
    Then I should see the message "<expectedmessage>"

    Examples:
      | username          | password             | expectedmessage                |
      | tomsmith          | SuperSecretPassword! | You logged into a secure area! |
      | incorrectusername | incorrectpassordf    | Your username is valid!        |